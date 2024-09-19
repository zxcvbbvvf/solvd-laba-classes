package com.solvd.student.charles_borabon.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.solvd.student.charles_borabon.threads.Employee_Management.Employee;
import com.solvd.student.charles_borabon.threads.Employee_Management.Intern;

// Step 2: Thread-safe Employee pool using BlockingQueue and lazy initialization
class EmployeePool {
    private static final int MAX_POOL_SIZE = 5;
    private final BlockingQueue<Employee> employeeQueue;

    private EmployeePool() {
        employeeQueue = new LinkedBlockingQueue<>(MAX_POOL_SIZE);
        // Assuming Employee class has a constructor with ID or Name
        for (int i = 1; i <= MAX_POOL_SIZE; i++) {
            employeeQueue.offer(new Intern("Employee-" + i, i, 0.0, 0));
        }
    }

    // Lazy initialization with Singleton pattern
    private static class SingletonHolder {
        private static final EmployeePool INSTANCE = new EmployeePool();
    }

    public static EmployeePool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Employee getEmployee() throws InterruptedException {
        return employeeQueue.take(); // Waits if no employee is available
    }

    public void releaseEmployee(Employee employee) {
        employeeQueue.offer(employee);
    }
}

// Step 4: Task using Future and CompletionStage to acquire Employee
class EmployeeTask implements Callable<Employee> {
    private final EmployeePool employeePool;

    public EmployeeTask(EmployeePool pool) {
        this.employeePool = pool;
    }

    @Override
    public Employee call() throws InterruptedException {
        return employeePool.getEmployee();
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Step 3: Create a pool of Employees (size 5) and use 7 threads
        EmployeePool employeePool = EmployeePool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);

        // Threads simulate the use of employees for various tasks
        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                try {
                    Employee employee = employeePool.getEmployee();
                    System.out.println(Thread.currentThread().getName() + " acquired " + employee.getName());
                    // Simulate work with employee
                    Thread.sleep(2000);
                    employeePool.releaseEmployee(employee);
                    System.out.println(Thread.currentThread().getName() + " released " + employee.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // Step 4: Using CompletionStage and Future for asynchronous employee handling
        System.out.println("Starting CompletionStage and Future example with Employee pool...");
        ExecutorService futureExecutor = Executors.newFixedThreadPool(5);

        // Example of Future
        Future<Employee> future = futureExecutor.submit(new EmployeeTask(employeePool));
        Employee futureEmployee = future.get(); // Blocking call until employee is available
        System.out.println("Future acquired employee: " + futureEmployee.getName());

        // Example of CompletionStage using CompletableFuture
        CompletableFuture<Void> futureTasks = CompletableFuture.supplyAsync(() -> {
            try {
                return employeePool.getEmployee();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }, futureExecutor).thenAccept(employee -> {
            if (employee != null) {
                System.out.println("Async task acquired employee " + employee.getName());
                employeePool.releaseEmployee(employee);
            }
        });

        futureTasks.join(); // Non-blocking wait for all tasks to complete
        futureExecutor.shutdown();
    }
}

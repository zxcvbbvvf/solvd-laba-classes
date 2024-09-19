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

// Step 2: Mocked Connection class
class Connection {
    private static int counter = 0;
    private final int id;

    public Connection() {
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Connection{" + "id=" + id + '}';
    }
}

// Step 2: Thread-safe connection pool using BlockingQueue and lazy initialization
class ConnectionPool {
    private static final int MAX_POOL_SIZE = 5;
    private final BlockingQueue<Connection> connectionQueue;

    private ConnectionPool() {
        connectionQueue = new LinkedBlockingQueue<>(MAX_POOL_SIZE);
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            connectionQueue.offer(new Connection());
        }
    }

    // Lazy initialization with Singleton pattern
    private static class SingletonHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Connection getConnection() throws InterruptedException {
        return connectionQueue.take(); // Waits if no connection is available
    }

    public void releaseConnection(Connection connection) {
        connectionQueue.offer(connection);
    }
}

// Step 4: Task using Future and CompletionStage
class ConnectionTask implements Callable<Connection> {
    private final ConnectionPool connectionPool;

    public ConnectionTask(ConnectionPool pool) {
        this.connectionPool = pool;
    }

    @Override
    public Connection call() throws InterruptedException {
        return connectionPool.getConnection();
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Step 3: Create a pool of connections (size 5) and use 7 threads
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                try {
                    Connection conn = connectionPool.getConnection();
                    System.out.println(Thread.currentThread().getName() + " acquired " + conn);
                    // Simulate work with connection
                    Thread.sleep(2000);
                    connectionPool.releaseConnection(conn);
                    System.out.println(Thread.currentThread().getName() + " released " + conn);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // Step 4: Using CompletionStage and Future for asynchronous connection handling
        System.out.println("Starting CompletionStage and Future example...");
        ExecutorService futureExecutor = Executors.newFixedThreadPool(5);

        // Example of Future
        Future<Connection> future = futureExecutor.submit(new ConnectionTask(connectionPool));
        System.out.println("Future acquired connection " + future.get()); // Blocking call until connection is available

        // Example of CompletionStage using CompletableFuture
        CompletableFuture<Void> futureTasks = CompletableFuture.supplyAsync(() -> {
            try {
                return connectionPool.getConnection();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }, futureExecutor).thenAccept(connection -> {
            if (connection != null) {
                System.out.println("Async task acquired connection " + connection);
                connectionPool.releaseConnection(connection);
            }
        });

        futureTasks.join(); // Non-blocking wait for all tasks to complete
        futureExecutor.shutdown();
    }
}

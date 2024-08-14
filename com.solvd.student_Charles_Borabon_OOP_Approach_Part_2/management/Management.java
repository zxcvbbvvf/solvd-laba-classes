package management;
import java.util.Random;

public class Management implements ManagementMethods {
    private int id;
    private String name;
    static int managementCount = 0;
    static int[] managementIds = new int[1000];
    private static int managementIndex = 0;
    
    public Management(String name) {
        Random rand = new Random();
        this.id = rand.nextInt(1000);
        while (contains(managementIds, id) && managementCount < UPPER_BOUND) {
            this.id = rand.nextInt(1000);
        }
        if (managementCount >= UPPER_BOUND) {
            System.out.println("The maximum number of management objects has been reached.");
            return;
        }

        this.name = name;
        managementCount++;
        managementIds[managementIndex] = this.id;
        managementIndex++;
    }

    private boolean contains(int[] idList, int key) {
        for (int i = 0; i < idList.length; i++) {
            if (idList[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static int getManagementCount() {
        return managementCount;
    }

    @Override
    public String toString() {
        return "This is the main management class";
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

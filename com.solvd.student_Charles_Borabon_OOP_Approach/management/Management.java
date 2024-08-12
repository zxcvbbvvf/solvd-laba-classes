package management;
import java.util.Random;

public class Management {
    int id;
    String name;
    
    public Management(String name) {
        this.id = new Random().nextInt(1000);
        this.name = name;
    }

    @Override
    public String toString() {
        return "This is the main management class";
    }

    public int getId() {
        return this.id;
    }
}

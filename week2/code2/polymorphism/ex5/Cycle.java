package week2.code2.polymorphism.ex5;

public class Cycle {
    public void ride() {
        System.out.println("Riding a cycle with " + wheels() + " wheels");
    }

    public int wheels() {
        return 0; // Lớp cơ sở trả về 0
    }
}

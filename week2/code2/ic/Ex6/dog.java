package week2.code2.ic.Ex6;

public class dog {
    public void bark() {
        System.out.println("Woof!");
    }
    public void bark(int times, String status) {
        System.out.println("Woof! Woof! (barked " + times + " times with status: " + status + ")");
    }
    public void bark(String status, int times) {
        System.out.println("Woof! Woof! (status: " + status + " with " + times + " barks)");
    }

    public static void main(String[] args) {
        dog dog = new dog();
        dog.bark();
        dog.bark(3, "excited");
        dog.bark("joyful", 2);
    }
}


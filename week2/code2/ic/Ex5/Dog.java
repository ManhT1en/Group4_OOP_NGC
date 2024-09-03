package week2.code2.ic.Ex5;

public class Dog {
    public void bark() {
        System.out.println("Woof!");
    }
    public void bark(int times) {
        System.out.println("Woof! Woof! (barked " + times + " times)");
    }

    public void bark(String status) {
        System.out.println("Woof! Woof! (status: " + status + ")");
    }
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.bark(1);
        dog.bark("happy");
    }
}


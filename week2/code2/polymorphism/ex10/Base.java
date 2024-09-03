package week2.code2.polymorphism.ex10;

public class Base {
    public void firstMethod() {
        System.out.println("Base firstMethod");
        secondMethod();
    }

    public void secondMethod() {
        System.out.println("Base secondMethod");
    }
}
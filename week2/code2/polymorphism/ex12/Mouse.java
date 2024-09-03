package week2.code2.polymorphism.ex12;

public class Mouse extends Rodent {
    Mouse() {
        System.out.println("Mouse constructor");
    }

    @Override
    public void eat() {
        System.out.println("Mouse is eating");
    }
}

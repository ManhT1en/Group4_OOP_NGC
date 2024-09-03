package week2.code2.polymorphism.ex15;

public class Bicycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a bicycle");
    }

    public void balance() {
        System.out.println("Bicycle balancing");
    }
}

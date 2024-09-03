package week2.code2.polymorphism.ex15;

public class Unicycle extends Cycle {
    @Override
    public void ride() {
        System.out.println("Riding a unicycle");
    }

    public void balance() {
        System.out.println("Unicycle balancing");
    }
}

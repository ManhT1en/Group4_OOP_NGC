package week2.code2.polymorphism.ex15;

public class Exercise15 {
    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        for (Cycle cycle : cycles) {
            if (cycle instanceof Unicycle) {
                ((Unicycle) cycle).balance();
            } else if (cycle instanceof Bicycle) {
                ((Bicycle) cycle).balance();
            } else {
                System.out.println("Tricycle does not have balance method");
            }
        }
    }
}
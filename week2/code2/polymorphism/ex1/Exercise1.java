package week2.code2.polymorphism.ex1;

public class Exercise1 {
    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        for (Cycle cycle : cycles) {
            cycle.ride();
        }
    }
}
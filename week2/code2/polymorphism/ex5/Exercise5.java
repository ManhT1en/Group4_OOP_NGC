package week2.code2.polymorphism.ex5;

public class Exercise5 {
    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        for (Cycle cycle : cycles) {
            cycle.ride(); // In ra số bánh của mỗi loại
        }
    }
}
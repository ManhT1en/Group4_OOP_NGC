package week2.code1.main.java.com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class NNCollection {
    private List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    @Override
    public String toString() {
        return "NNCollection{numbers=" + numbers + "}";
    }
}

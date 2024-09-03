package week2.code2.polymorphism.ex11;

public class Sandwich {
    private String name;

    public Sandwich(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sandwich: " + name;
    }
}
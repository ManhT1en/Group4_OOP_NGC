package week2.code1.main.java.com.mycompany.app;

public class NameNumber {
    private String name;

    public NameNumber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NameNumber{name='" + name + "'}";
    }
}

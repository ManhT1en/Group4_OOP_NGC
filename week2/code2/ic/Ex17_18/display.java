package week2.code2.ic.Ex17_18;

public class display {
    private String message;

    public display(String message) {
        this.message = message;
        System.out.println("Constructor with argument: " + message);
    }

    @Override
    public String toString() {
        return message;
    }
}

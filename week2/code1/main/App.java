package week2.code1.main;

public class App {
    public static void main(String[] args) {
        // Tạo và sử dụng Book
        Book book = new Book("1984");
        System.out.println(book);

        // Tạo và sử dụng Time
        Time time = new Time(10);
        System.out.println(time);

        // Tạo và sử dụng Recursion
        Recursion recursion = new Recursion();
        System.out.println("Giai thừa của 5: " + recursion.factorial(5));

        // Tạo và sử dụng NNCollection
        NNCollection collection = new NNCollection();
        collection.addNumber(1);
        collection.addNumber(2);
        System.out.println(collection);

        // Tạo và sử dụng NameNumber
        NameNumber nameNumber = new NameNumber("Alice");
        System.out.println(nameNumber);
    }
}

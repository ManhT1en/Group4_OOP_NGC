package week2.code2.polymorphism.ex6;

public class Music3 {
    public static void main(String[] args) {
        Instrument[] instruments = {new Wind(), new Percussion()};
        for (Instrument instrument : instruments) {
            System.out.println(instrument); // Sẽ gọi phương thức toString()
        }
    }
}
package week2.code2.polymorphism.ex7;

public class Music3 {
    public static void main(String[] args) {
        Instrument[] instruments = {new Wind(), new Percussion(), new Stringed()};
        for (Instrument instrument : instruments) {
            System.out.println(instrument); // Kiểm tra tính đa hình với loại mới
        }
    }
}

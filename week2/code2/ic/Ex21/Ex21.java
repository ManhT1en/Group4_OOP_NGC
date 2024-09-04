package week2.code2.ic.Ex21;

public class Ex21 {
    public static void main(String[] args) {
        // Lặp qua tất cả các giá trị của enum Ex21
        for (EnumExample currency : EnumExample.values()) {
            System.out.println(currency + " has ordinal " + currency.ordinal());
        }
    }
}

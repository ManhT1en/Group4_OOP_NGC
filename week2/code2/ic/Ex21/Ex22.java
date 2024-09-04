package week2.code2.ic.Ex21;

public class Ex22 {
    public static void main(String[] args) {
        for (EnumExample currency : EnumExample.values()) {
            switch (currency) {
                case ONE_DOLLAR:
                    System.out.println("ONE_DOLLAR: A one dollar bill.");
                    break;
                case FIVE_DOLLARS:
                    System.out.println("FIVE_DOLLARS: A five dollar bill.");
                    break;
                case TEN_DOLLARS:
                    System.out.println("TEN_DOLLARS: A ten dollar bill.");
                    break;
                case TWENTY_DOLLARS:
                    System.out.println("TWENTY_DOLLARS: A twenty dollar bill.");
                    break;
                case FIFTY_DOLLARS:
                    System.out.println("FIFTY_DOLLARS: A fifty dollar bill.");
                    break;
                case HUNDRED_DOLLARS:
                    System.out.println("HUNDRED_DOLLARS: A hundred dollar bill.");
                    break;
                default:
                    System.out.println("Unknown currency.");
                    break;
            }
        }
    }
}

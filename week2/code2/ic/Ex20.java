package week2.code2.ic;

public class Ex20 {
    public static void main(String... string) {
        System.out.println("Number of command-line arguments: " + string.length);
        System.out.println("Command-line arguments:");
        for (String st : string) {
            System.out.println(st);
        }
    }
}

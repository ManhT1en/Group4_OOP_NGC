package week2.code2.ic;

public class Ex19 {
    public static void printStrings(String... strings) {
        System.out.println("Number of strings: " + strings.length);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        printStrings("Hello", "World", "Java", "Varargs");
        String[] stringArray = {"Apple", "Banana", "Cherry"};
        printStrings(stringArray);
    }
}
//printStrings(String... strings) dùng để nhận 1 danh sách các chuỗi string
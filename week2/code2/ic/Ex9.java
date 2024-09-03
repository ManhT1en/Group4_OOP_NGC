package week2.code2.ic;

public class Ex9 {
    public Ex9() {
        this("default value"); 
        System.out.println("Constructor khong tham so");
    }
    public Ex9(String value) {
        System.out.println("Constructor co tham so: " + value);
    }

    public static void main(String[] args) {
        Ex9 mt1 = new Ex9();
        Ex9 mt2 = new Ex9("custom value");
    }
}

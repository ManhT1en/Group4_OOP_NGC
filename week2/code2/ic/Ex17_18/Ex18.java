package week2.code2.ic.Ex17_18;

public class Ex18 {
    public static void main(String[] args) {
        display[] array = new display[3];
        array[0] = new display("Nguyen Manh Tien");
        array[1] = new display("Gioi tinh: Nam");
        array[2] = new display("Age: 19");
        
        System.out.println("Information:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element" + i + ": " + array[i]);
        }
    }
}

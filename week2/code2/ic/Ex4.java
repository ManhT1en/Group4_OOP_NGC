package week2.code2.ic;

public class Ex4 {
    // Constructor mặc định
    public Ex4() {
        System.out.println("I am Manh Tien");
    }

    // Constructor quá tải nhận một tham số String
    public Ex4(String age) {
        System.out.println("I am Manh Tien " + age);
    }

    // Phương thức display
    public void display() {
        System.out.println("Display method");
    }

    // Phương thức main
    public static void main(String[] args) {
        // Tạo đối tượng bằng constructor mặc định
        Ex4 mt1 = new Ex4();

        // Tạo đối tượng bằng constructor quá tải
        Ex4 mt2 = new Ex4("19 years old");

        // Gọi phương thức display
        mt1.display();
        mt2.display();
    }
}

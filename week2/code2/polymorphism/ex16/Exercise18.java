package week2.code2.polymorphism.ex16;

public class Exercise18 {
    public static void main(String[] args) {
        Base base = new Derived();
        try {
            base.method(); // Không thể ném ngoại lệ mới
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
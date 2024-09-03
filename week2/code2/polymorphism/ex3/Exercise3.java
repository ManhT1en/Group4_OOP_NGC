package week2.code2.polymorphism.ex3;

public class Exercise3 {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Square()};
        for (Shape shape : shapes) {
            shape.printMessage(); // Đoạn mã này sẽ gọi phương thức printMessage() từ lớp Shape.
        }
    }
}
package week2.code2.polymorphism.ex4;

public class Exercise4 {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Square(), new Triangle()};
        for (Shape shape : shapes) {
            shape.draw(); // Kiểm tra tính đa hình với loại mới
        }
    }
}
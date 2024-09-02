package week2.code2.polymorphism.ex2;

public class Exercise2 {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Square()};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
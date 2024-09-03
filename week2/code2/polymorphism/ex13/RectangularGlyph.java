package week2.code2.polymorphism.ex13;

public class RectangularGlyph extends Glyph {
    RectangularGlyph() {
        System.out.println("RectangularGlyph constructor");
    }

    @Override
    public void draw() {
        System.out.println("RectangularGlyph draw");
    }
}

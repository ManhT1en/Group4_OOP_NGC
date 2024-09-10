package week2.code2.rc;

public class Ex6 {
    static class Game {
        Game(int i) {
            System.out.println("Game constructor");
        }
    }
    static class BoardGame extends Game {

        BoardGame(int i) {
            super(i); 
            System.out.println("BoardGame constructor");
        }
    }
    
    static public class Chess extends BoardGame {
        Chess() {
            super(11); 
            System.out.println("Chess constructor");
        }
    
    }
    public static void main(String[] args) {
        Chess x = new Chess(); 
    }
}

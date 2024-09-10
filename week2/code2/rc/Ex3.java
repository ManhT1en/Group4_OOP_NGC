package week2.code2.rc;

public class Ex3 {
    static class Infor{
        public Infor() {
            System.out.println("Manh Tien");
        }
    }
    static class printInfor extends Infor{
    }
    
    public static void main(String[] args) {
        printInfor mt = new printInfor();
    }
}


package week2.code2.ic;

public class Ex8 {
    public void firstMethod() {
        System.out.println("su dung this");
        secondMethod(); 

        System.out.println("khong su dung this");
        this.secondMethod(); 
    }
    public void secondMethod() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Ex8 example = new Ex8();
        example.firstMethod(); 
    }
}

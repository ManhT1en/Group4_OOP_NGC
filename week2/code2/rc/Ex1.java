package week2.code2.rc;


class message {
    private String name;

    public message() {
        name = "Nguyen Manh Tien";
        System.out.println(name);
    }

    public void printMess() {
        System.out.println("ten toi la: " + name);
    }
}

public class Ex1 {
    private message mt;

    public void infor() {
        if (mt == null) {
            System.out.println("no information");
            mt = new message();
        }
        mt.printMess();
    }

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
        ex1.infor(); 
    }
}

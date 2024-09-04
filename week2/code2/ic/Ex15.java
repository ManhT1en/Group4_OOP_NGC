package week2.code2.ic;

public class Ex15 {
    String name;
    {
        name = "Nguyen Manh Tien";
    }
    Ex15(){
    }
    void display(){
        System.out.println("My name is " + name);
    }
    public static void main(String[] args) {
        Ex15 mt = new Ex15();
        mt.display();
    }
}

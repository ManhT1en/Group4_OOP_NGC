package week2.code2.rc;

class Name{
    public Name() {
        System.out.println("Manh Tien");
    }
}
class Age extends Name{
    public Age(){
        System.out.println("19 year old");
    }
}
public class Ex4 {
    public static void main(String[] args) {
        Age mt = new Age();
    }
}

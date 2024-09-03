package week2.main;
import week2.code2.ac.Ex4.pk1.a1;
import week2.code2.ac.Ex4.pk1.a2;
import week2.code2.ac.Ex4.pk2.b2;

public class testEx4 extends a1{
    public static void main(String[] args) {
        a2 a = new a2();
        a.accessProtected();
        //b1 b = new b1(); //k có quyền truy cập
        b2 c = new b2();
        c.accessProtected();
    }
}
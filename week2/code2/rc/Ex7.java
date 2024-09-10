package week2.code2.rc;

public class Ex7 {
    
    static class A {
        A(String a) {
            System.out.println("A constructor: " + a);
        }
    }

    static class B {
        B(String b) {
            System.out.println("B constructor: " + b);
        }
    }

    static class C extends A {
        B b; 

        C(String a, String b) {
            super(a); 
            this.b = new B(b); 
            System.out.println("C constructor");
        }

    }
    public static void main(String[] args) {
        C c = new C("Hello", "World"); 
    }

}

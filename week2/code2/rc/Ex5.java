package week2.code2.rc;

public class Ex5 {
    
    static class A {
        public A() {
            System.out.println("A's constructor called");
        }
    }

    static class B {
        public B() {
            System.out.println("B's constructor called");
        }
    }
    static public class C extends A {
        // Member of class B
        private B b = new B();
    }
    
    public static void main(String[] args) {
        C c = new C();
    }
}

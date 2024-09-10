package week2.code2.rc;

public class Ex2 {
    static class Cleanser {
        private String s = "Cleanser";
        public void append(String a) { s += a; }
        public void dilute() { append(" dilute()"); }
        public void apply() { append(" apply()"); }
        public void scrub() { append(" scrub()"); }
        @Override
        public String toString() { return s; }
        public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        System.out.println(x);
        }
       }
       static public class Detergent extends Cleanser {
        @Override
        public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
        }
        // Add methods to the interface:
        public void foam() { append(" foam()"); }
        public void sterilize(){
            append("sterilize()");
        }
        // Test the new class:
        public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
        }
    }
}

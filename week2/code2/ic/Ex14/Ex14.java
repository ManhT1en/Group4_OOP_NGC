package week2.code2.ic.Ex14;

public class Ex14 {
    static String out = "in definition";
    static String block; 
    static {
        block = "in static block";
    }
    static void display(){
        System.out.println("field initialized at definition" +out);
        System.out.println("field initialized in static block" +block);
    }
}

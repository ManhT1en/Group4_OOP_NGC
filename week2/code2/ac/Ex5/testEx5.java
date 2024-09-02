package week2.code2.ac.Ex5;

public class testEx5 {
    public static void main(String[] args) {
        accessLevel mt = new accessLevel();
        System.out.println("public field " +mt.pubString);
        //System.out.println("private field" +mt.priString); //không hợp lệ 
        System.out.println("protected field" +mt.proString);
        System.out.println("package field" +mt.packField);

        mt.pubMethod();
        mt.proMethod();
        mt.packMethod();
        //mt.priMethod(); //không hợp lệ
    }
}

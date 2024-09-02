package week2.code2.ac.Ex5;

public class accessLevel {
    public String pubString = "Hop le";
    private String priString = "Khong hop le";
    protected String proString = "Hop le trong package + subclass";
    String packField = "hop le trong package";
    public void pubMethod(){
        System.out.println("public method");
    }
    private  void priMethod(){
        System.out.println("private method");
    }
    protected void proMethod(){
        System.out.println("protected method");
    }
    void packMethod(){
        System.out.println("package method");
    }
}

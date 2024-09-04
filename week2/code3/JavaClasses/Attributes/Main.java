package week2.code3.JavaClasses.Attributes;

public class Main {
    String fname = "Linh";
    String lname = "Chi";
    int age = 19;
  
    public static void main(String[] args) {
      Main myObj = new Main();
      System.out.println("Name: " + myObj.fname + " " + myObj.lname);
      System.out.println("Age: " + myObj.age);
    }
  }
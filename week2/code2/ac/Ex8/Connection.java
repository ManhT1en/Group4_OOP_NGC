package week2.code2.ac.Ex8;

public class Connection {
    private Connection(){} 
    public static Connection createConnection(){
        return new Connection();
    }
    public void performAction(){
        System.out.println("Da ket noi");
    }
}

package week2.code2.ic;

public class Ex2 {
    public String mt1 = "khoi tao tai khai bao";
    public String mt2;
    public Ex2(String value){
        this.mt2 = value;
    }
    public void display(){
        System.out.println("gia tri cua mt1: " +mt1);
        System.out.println("gia tri cua mt2: " +mt2);
    }
    public static void main(String[] args) {
        Ex2 mt = new Ex2("khoi tao trong constructor");
        mt.display();
    }
}
// nhận xét
// biến khởi tạo trong constructor linh hoạt hơn, có thể thay đổi cho từng đối tượng khác nhau

package week2.code2.ac;

public class Ex6 {
    class info {
        protected String data = "Nguyen Manh Tien";
    }

    public void display() {
        info mt = new info();
        System.out.println("Ten toi la: " + mt.data);
    }

    class mt1 {
        public void multi(info mt1) {
            mt1.data += " 19 tuoi";
            System.out.println("Information: " + mt1.data);
        }
    }

    public static void main(String[] args) {
        Ex6 ex6 = new Ex6(); // Tạo đối tượng của Ex6
        ex6.display(); // Gọi phương thức display()

        info in4 = ex6.new info(); // Tạo đối tượng của info thông qua ex6
        mt1 mt = ex6.new mt1(); // Tạo đối tượng của mt1 thông qua ex6
        mt.multi(in4); // Gọi phương thức multi() và truyền đối tượng in4
    }
}

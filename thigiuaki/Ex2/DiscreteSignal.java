package thigiuaki.Ex2;

public class DiscreteSignal {
    private int[] x;

    // Khởi tạo tín hiệu với mảng đầu vào
    public DiscreteSignal(int[] x) {
        this.x = x;
    }

    // Phương thức trả về giá trị tín hiệu tại vị trí n
    public int getValueAt(int n) {
        if (n >= 0 && n < x.length) {
            return x[n];
        } else {
            return 0; // Nếu ngoài phạm vi mảng, trả về 0 (giả định theo dãy xung đơn vị)
        }
    }

    // Phương thức hiển thị toàn bộ tín hiệu
    public void displaySignal() {
        for (int i = 0; i < x.length; i++) {
            System.out.println("x(" + i + ") = " + getValueAt(i));
        }
    }

    public static void main(String[] args) {
        int[] signalValues = {1, 2, 3, 4, 5}; // Ví dụ tín hiệu rời rạc
        DiscreteSignal signal = new DiscreteSignal(signalValues);
        signal.displaySignal(); // Hiển thị tín hiệu
    }
}

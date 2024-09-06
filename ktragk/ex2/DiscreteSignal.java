package ktragk.ex2;

public class DiscreteSignal {
    private double[] signalValues;  // Mảng chứa các giá trị tín hiệu
    
    // Khởi tạo với các giá trị tín hiệu đầu vào
    public DiscreteSignal(double[] signalValues) {
        this.signalValues = signalValues;
    }

    // Hàm xung đơn vị
    public int delta(int n) {
        return (n == 0) ? 1 : 0;
    }

    // Tính giá trị x(n) cho tín hiệu rời rạc theo công thức tổng
    public double x(int n) {
        double result = 0;
        for (int k = 0; k < signalValues.length; k++) {
            result += signalValues[k] * delta(n - k);
        }
        return result;
    }
}

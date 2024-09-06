package thigiuaki.Ex1;

public class DiscreteSignal implements Signal {
    private double amplitude;
    private double frequency;
    private double wavelength;

    // Constructor để khởi tạo các giá trị
    public DiscreteSignal(double amplitude, double frequency, double wavelength) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.wavelength = wavelength;
    }

    // Triển khai các phương thức của giao diện Signal
    @Override
    public double getAmplitude() {
        return amplitude;
    }

    @Override
    public double getFrequency() {
        return frequency;
    }

    @Override
    public double getWavelength() {
        return wavelength;
    }

    // Phương thức tính toán tín hiệu rời rạc
    public double calculate(int n) {
        if (n == 0) {
            return amplitude;  // Ví dụ đơn giản: trả về biên độ nếu n = 0
        } else {
            return 0;
        }
    }
}


package thigiuaki.Ex1;

// Lớp tín hiệu liên tục
public class ContinuousSignal implements Signal {
    private double amplitude;
    private double frequency;
    private double wavelength;

    // Constructor để khởi tạo các giá trị
    public ContinuousSignal(double amplitude, double frequency, double wavelength) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.wavelength = wavelength;
    }

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
}

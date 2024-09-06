package ktragk.ex2;

public class mainTest {
    public static void main(String[] args) {
        // Tạo một đối tượng tín hiệu rời rạc với các giá trị mẫu
        double[] sampleValues = {1, 2, 3, 4, 5}; // Mẫu tín hiệu
        DiscreteSignal discreteSignal = new DiscreteSignal(sampleValues);
        
        // Tính giá trị tín hiệu rời rạc x(4)
        System.out.println("Gia tri x(4): " + discreteSignal.x(4));
        
        // Tạo một đối tượng radar và tính X(4)
        Radar radar = new Radar();
        System.out.println("Gia tri X(4): " + radar.X(4));
}
}


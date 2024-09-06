package ktragk.ex1;

public class mainTest {
    public static void main(String[] args) {
        // Create instances of ContinuousSignal and DiscreteSignal
        ContinuousSignal continuousSignal = new ContinuousSignal(5.0, 2.0, 1.0, 10.0);
        DiscreteSignal discreteSignal = new DiscreteSignal(3.0, 1.5, 0.5, 5.0);

        // Display properties of ContinuousSignal
        System.out.println("Continuous Signal Properties:");
        System.out.println("Bien Do: " + continuousSignal.getBienDo());
        System.out.println("Chu Ki: " + continuousSignal.getChuKi());
        System.out.println("Buoc Song: " + continuousSignal.getBuocSong());
        System.out.println("Tan So: " + continuousSignal.getTanSo());
        continuousSignal.displayContinuousSignal();

        // Display properties of DiscreteSignal
        System.out.println("\nDiscrete Signal Properties:");
        System.out.println("Bien Do: " + discreteSignal.getBienDo());
        System.out.println("Chu Ki: " + discreteSignal.getChuKi());
        System.out.println("Buoc Song: " + discreteSignal.getBuocSong());
        System.out.println("Tan So: " + discreteSignal.getTanSo());
        discreteSignal.displayDiscreteSignal();
    }
}

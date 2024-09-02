package week2.code1.main.java.com.mycompany.app;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public void displayTime() {
        System.out.println("Time: " + hours + "h " + minutes + "m");
    }

    public int toMinutes() {
        return hours * 60 + minutes;
    }
}

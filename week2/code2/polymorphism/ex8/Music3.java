package week2.code2.polymorphism.ex8;

import java.util.Random;

public class Music3 {
    public static void main(String[] args) {
        Random rand = new Random();
        Instrument[] instruments = new Instrument[10];
        for (int i = 0; i < instruments.length; i++) {
            switch (rand.nextInt(3)) {
                case 0:
                    instruments[i] = new Wind();
                    break;
                case 1:
                    instruments[i] = new Percussion();
                    break;
                case 2:
                    instruments[i] = new Stringed();
                    break;
            }
        }
        for (Instrument instrument : instruments) {
            System.out.println(instrument);
        }
    }
}
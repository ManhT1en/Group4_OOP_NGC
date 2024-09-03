package week2.code2.polymorphism.ex9;

public class Exercise9 {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};
        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
        }
    }
}
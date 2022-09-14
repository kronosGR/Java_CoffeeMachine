package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        int milk = 50;
        int water = 200;
        int coffeeBeams = 15;

        System.out.println("Write how many cups of coffee you will need: ");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();

        System.out.println("For " + amount + " cups of coffee you will need:");
        System.out.println((amount * water) + " ml of water");
        System.out.println((amount * milk) + " ml of milk");
        System.out.println((amount * coffeeBeams) + " g of coffee beans");
    }
}

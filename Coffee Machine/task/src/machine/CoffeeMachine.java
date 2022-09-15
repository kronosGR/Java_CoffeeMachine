package machine;

import java.util.Scanner;

class Coffee {

    private int water;
    private int milk;
    private int coffeeBeans;

    Coffee(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {

        Coffee coffee = new Coffee(200, 50, 15);

        int milk = 0;
        int water = 0;
        int coffeeBeans = 0;

        Scanner sc = new Scanner(System.in);

//        System.out.println("For " + amount + " cups of coffee you will need:");
//        System.out.println((amount * water) + " ml of water");
//        System.out.println((amount * milk) + " ml of milk");
//        System.out.println((amount * coffeeBeans) + " g of coffee beans");

        System.out.println("Write how many ml of water the coffee machine has:");
        water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int amount = sc.nextInt();

        int maxMilk = milk / coffee.getMilk();
        int maxWater = water / coffee.getWater();
        int maxCoffeeBeans = coffeeBeans / coffee.getCoffeeBeans();

        int min = Math.min(maxMilk, maxWater);
        if (maxCoffeeBeans < min) {
            min = maxCoffeeBeans;
        }

        if (maxMilk >= amount && maxWater >= amount && maxCoffeeBeans >= amount) {
            if (min == amount) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (min - amount) + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        }
    }
}

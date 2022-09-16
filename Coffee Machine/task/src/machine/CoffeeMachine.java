package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Coffee {

    private String name;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int price;


    Coffee(String name, int water, int milk, int coffeeBeans, int price) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Machine {

    int milk = 540;
    int water = 400;
    int coffeeBeans = 120;
    int cups = 9;
    int money = 550;

    public static Coffee ESPRESSO = new Coffee("espresso", 250, 0, 16, 4);
    public static Coffee LATTE = new Coffee("latte", 350, 75, 20, 7);
    public static Coffee CAPPUCCINO = new Coffee("cappuccino", 200, 100, 12, 6);

    Scanner sc = new Scanner(System.in);

    public void info() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffeeBeans + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" +this.money + " of money");
        System.out.println();
    }

    public String getInput() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return sc.nextLine();
    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        System.out.println();
        this.money = 0;
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        this.water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        this.cups += sc.nextInt();
        System.out.println();
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:)");
        String what = sc.nextLine();

        if (what.equals("back")) return;

        switch (Integer.parseInt(what)) {
            case 1:
                use(Machine.ESPRESSO);
                break;
            case 2:
                use(Machine.LATTE);
                break;
            case 3:
                use(Machine.CAPPUCCINO);
                break;
        }
    }

    public void use(Coffee coffee) {
        String msg = "I have enough resources, making you a coffee!";
        if (this.milk - coffee.getMilk() < 0) {
            msg = "Sorry, not enough milk!";
        }
        if (this.water - coffee.getWater() < 0) {
            msg = "Sorry, not enough water!";
        }
        if (this.coffeeBeans - coffee.getCoffeeBeans() < 0) {
            msg = "Sorry, not enough coffee beans!";
        }
        if (this.cups - 1 < 0) {
            msg = "Sorry, not enough disposable cups!";
        }

        if (msg.equals("I have enough resources, making you a coffee!")) {
            this.milk -= coffee.getMilk();
            this.coffeeBeans -= coffee.getCoffeeBeans();
            this.water -= coffee.getWater();
            this.cups--;
            this.money += coffee.getPrice();
        }

        System.out.println(msg);
        System.out.println();
    }
}

public class CoffeeMachine {


    public static void main(String[] args) {

        Machine machine = new Machine();

        String order;
        loop:
        while (true) {
            order = machine.getInput();

            switch (order) {
                case "buy":
                    machine.buy();
                    break;
                case "fill":
                    machine.fill();
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    machine.info();
                    break;
                case "exit":
                    break loop;
            }
        }
    }
}

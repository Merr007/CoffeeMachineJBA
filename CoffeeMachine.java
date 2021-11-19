package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static final Scanner sc = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;
    static boolean flag;
    static String typeOfCoffee;

    public static void main(String[] args) {
        menu();
    }

    public static void state() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
    public static void menu() {
        flag = true;
        while (flag) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            switch (sc.next()) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    state();
                    break;
                case "exit":
                    flag = false;
                    break;
            }
        }
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        typeOfCoffee = sc.next();
        while (true) {
            if (typeOfCoffee.equals("back")) {
                break;
            } else if (typeOfCoffee.equals("1")) {
                if (CoffeeType.ESPRESSO.getWater() > water) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (CoffeeType.ESPRESSO.getMilk() > milk) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (CoffeeType.ESPRESSO.getCoffeeBeans() > coffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (CoffeeType.ESPRESSO.getCups() > cups) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    cups -= 1;
                    money += 4;
                    break;
                }
            } else if (typeOfCoffee.equals("2")) {
                if (CoffeeType.LATTE.getWater() > water) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (CoffeeType.LATTE.getMilk() > milk) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (CoffeeType.LATTE.getCoffeeBeans() > coffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (CoffeeType.LATTE.getCups() > cups) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    cups -= 1;
                    money += 7;
                    break;
                }
            } else {
                if (CoffeeType.CAPPUCCINO.getWater() > water) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (CoffeeType.CAPPUCCINO.getMilk() > milk) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (CoffeeType.CAPPUCCINO.getCoffeeBeans() > coffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (CoffeeType.CAPPUCCINO.getCups() > cups) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    cups -= 1;
                    money += 6;
                    break;
                }
            }
        }
    }

        public static void fill() {
            System.out.println("Write how many ml of water you want to add:");
            water += sc.nextInt();
            System.out.println("Write how many ml of milk you want to add:");
            milk += sc.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            coffeeBeans += sc.nextInt();
            System.out.println("Write how many disposable cups of coffee you want to add:");
            cups += sc.nextInt();
        }

        public static void take() {
            System.out.println("I gave you $" + money);
            money = 0;
        }
    }

enum CoffeeType {
    ESPRESSO(250, 0, 16, 1),
    LATTE(300, 75, 20, 1),
    CAPPUCCINO(200, 100, 12, 1);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;

     CoffeeType(int water, int milk, int coffeeBeans, int cups) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCups() { return cups; }
}




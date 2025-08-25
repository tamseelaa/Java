package week1.five;
import java.util.Scanner;
public class CoffeeSystemStarter {
    public static void main(String[] args) {
        Scanner order= new Scanner(System.in);
        CoffeeMaker cm = new CoffeeMaker();

        cm.turnOn();
        System.out.println("\n\nCoffee maker is on");

        cm.setCoffeeType("espresso");
        cm.setCoffeeAmount(50);

        System.out.println("Coffee type is " + cm.getCoffeeType());
        System.out.println("Coffee amount is " + cm.getCoffeeAmount() + " ml");

        cm.turnOff();
        System.out.println("Coffee maker is off");
        //""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

        CoffeeMaker machine = new CoffeeMaker();
        machine.turnOn();
        System.out.println("Coffee maker is on");

        System.out.println("\n\n Do you want to order normal or espresso?🙂");
        String input= order.nextLine();
        machine.setCoffeeType(input);
        machine.setCoffeeAmount(50);

        System.out.println("Coffee type is " + machine.getCoffeeType());
        System.out.println("Coffee amount is " + machine.getCoffeeAmount() + " ml");
        System.out.println("Please wait a moment, your order is processing");
        System.out.println("Here's your coffee☕");
        machine.turnOff();
        System.out.println("Coffee maker is off");
    }
    }


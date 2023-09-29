import java.util.Scanner;

    public class TipCalculator {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scan.nextLine();
            System.out.println("Welcome, " + name + "!");
            System.out.print("How many people are in your party? ");
            int people = scan.nextInt();
            if (people <= 0) {
                while (people <= 0) {
                    people = 1;
                    System.out.println("Invalid input: positive integers only");
                    people = scan.nextInt();
                }
            }
            if (people > 0) {
                System.out.println(people + " guests");
            }
            System.out.print("What percent would you like to tip? ");
            int percentTip = scan.nextInt();
            if (percentTip <= 0) {
                while (percentTip <= 0) {
                    percentTip = 1;
                    System.out.println("Invalid input: pick an integer between 1 and 100");
                    percentTip = scan.nextInt();
                }
            }
            if (percentTip > 0) {
                System.out.println(percentTip + "% Tip");
            }
            System.out.println("Please enter the cost of an item in dollars and cents. If you are done, enter -1. ");
            double itemCost = scan.nextDouble();
            double totalCostOfItems = 0;
                if (itemCost > 0) {
                    while (itemCost > 0) {
                        itemCost = (double) ((int)((itemCost + 0.005) * 100)) / 100;
                        totalCostOfItems = totalCostOfItems + itemCost;
                        System.out.println("Rounded cost to nearest cent: $" + itemCost);
                        itemCost = 0.01;
                        itemCost = scan.nextDouble();
                    }
                }
            if (itemCost <= 0) {
                while (itemCost <= 0) {
                    if (itemCost > -1) {
                        System.out.println("Invalid input: must be a positive amount in dollars and cents");
                        itemCost = 0.01;
                        itemCost = scan.nextDouble();
                    }
                    if (itemCost < -1) {
                        System.out.println("Invalid input: must be a positive amount in dollars and cents");
                        itemCost = 0.01;
                        itemCost = scan.nextDouble();
                    }
                    if (itemCost == -1) {
                        itemCost = 0.01;
                        System.out.println("Total Cost Without Tip: $" + totalCostOfItems);
                    }
                }
            }
            double tip = ((int)((totalCostOfItems * (percentTip / 100)) * 100) / 100);
            double totalBill = totalCostOfItems + tip;
            double costPerPerson = ((int)((totalCostOfItems / people) * 100)) /100;
            double tipPerPerson = ((int)(((tip / people) + 0.005) * 100) / 100);
            double totalCostPerP = costPerPerson + tipPerPerson;

            //receipt
            System.out.println("------------------------------------------------");
            System.out.println("Name: " + name);
            System.out.println("Guests: " + people);
            System.out.println("Total Cost of Items: $" + totalCostOfItems);
            System.out.println("Tip Percentage: " + percentTip);
            System.out.println("Tip: $" + tip);
            System.out.println("Total Bill: $" + totalBill);
            System.out.println("Cost Per Person Without Tip: $" + costPerPerson);
            System.out.println("Tip Per Person: $" + tipPerPerson);
            System.out.println("Total Cost Per Person: $" + totalCostPerP);
            System.out.println("------------------------------------------------");




        }
    }
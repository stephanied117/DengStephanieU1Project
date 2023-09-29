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
                        if (itemCost - 0.01 < ((int)(itemCost * 10)) / 10.0) {
                            System.out.println("Rounded cost to nearest cent: $" + itemCost + "0");
                        } else {
                            System.out.println("Rounded cost to nearest cent: $" + itemCost);
                        }
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
            double tip = (double) ((int) ((totalCostOfItems * ((double) percentTip / 100) + 0.005) * 100)) / 100;
            double totalBill = totalCostOfItems + tip;
            double costPerPerson = ((int)((totalCostOfItems / people) * 100)) /100.0;
            double tipPerPerson = ((int)(((tip / people) + 0.005) * 100) / 100.0);
            double totalCostPerP = ((int)(((costPerPerson + tipPerPerson) + 0.005) * 100) / 100.0);

            // prints receipt border
            System.out.println("------------------------------------------------");

            // prints name
            System.out.println("Name: " + name);

            // prints people
            System.out.println("Guests: " + people);

            System.out.println( );

            // prints totalCostOfItems with two decimal places
            if (totalCostOfItems - 0.01 < ((int)(totalCostOfItems * 10)) / 10.0) {
                System.out.println("Total Cost of Items: $" + totalCostOfItems + "0");
            } else {
                System.out.println("Total Cost of Items: $" + totalCostOfItems);
            }

            // prints percentTip
            System.out.println("Tip Percentage: " + percentTip + "%");

            // prints tip with two decimal places
            if (tip - 0.01 < ((int)(tip * 10)) / 10.0) {
                System.out.println("Tip: $" + tip + "0");
            } else {
                System.out.println("Tip: $" + tip);
            }

            // prints totalBill with two decimal places
            if (totalBill - 0.01 < ((int)(totalBill * 10)) / 10.0) {
                System.out.println("Total Bill: $" + totalBill + "0");
            } else {
                System.out.println("Total Bill: $" + totalBill);
            }

            System.out.println( );

            // prints costPerPerson with two decimal places
            if (costPerPerson - 0.01 < ((int)(costPerPerson * 10)) / 10.0) {
                System.out.println("Cost Per Person Without Tip: $" + costPerPerson + "0");
            } else {
                System.out.println("Cost Per Person Without Tip: $" + costPerPerson);
            }

            // prints tipPerPerson with two decimal places
            if (tipPerPerson - 0.01 < ((int)(tipPerPerson * 10)) / 10.0) {
                System.out.println("Tip Per Person: $" + tipPerPerson + "0");
            } else {
                System.out.println("Tip Per Person: $" + tipPerPerson);
            }

            // prints tipPerPerson with two decimal places
            if (totalCostPerP - 0.01 < ((int)(totalCostPerP * 10)) / 10.0) {
                System.out.println("Total Cost Per Person: $" + totalCostPerP + "0");
            } else {
                System.out.println("Total Cost Per Person: $" + totalCostPerP);
            }

            // prints receipt border
            System.out.println("------------------------------------------------");
        }
    }
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TipCalculator {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            // asks for name and prints name
            System.out.print("Enter your name: ");
            String name = scan.nextLine();
            System.out.println("Welcome, " + name + "!");
            System.out.println( );
            // asks for number of people and prints number of people
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
                System.out.println( );
            }
            // asks for percentage of subtotal to be used for tip and prints percentage
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
                System.out.println( );
            }
            // asks for item price and name and prints them
            System.out.println("Please enter the cost of an item in dollars and cents. If you are done, enter -1. ");
            double itemCost = scan.nextDouble();
            // list code is from https://stackoverflow.com/questions/39881371/is-there-a-way-to-create-a-new-variable-from-user-input-in-java
            List<String> nameItem = new ArrayList<>();
            String itemName = (" ");
            String itemNameList = (" ");
            double totalCostOfItems = 0;
            while (itemCost != -1) {
                if (itemCost <= 0) {
                    while (itemCost <= 0) {
                        if (itemCost > -1) {
                            System.out.println("Invalid input: Must be a positive amount in dollars and cents.");
                        } else if (itemCost < -1) {
                            System.out.println("Invalid input: Must be a positive amount in dollars and cents.");
                        }
                        itemCost = scan.nextDouble();
                        scan.nextLine();
                    }
                } else if (itemCost > 0) {
                    while (itemCost > 0) {
                        itemCost = (double) ((int) ((itemCost + 0.005) * 100)) / 100;
                        totalCostOfItems = totalCostOfItems + itemCost;
                        if (itemCost - 0.01 < ((int) (itemCost * 10)) / 10.0) {
                            scan.nextLine();
                            System.out.println("Rounded cost to nearest cent: $" + itemCost + "0");
                            System.out.print("Enter the item name: ");
                            itemName = scan.nextLine();
                            // code is from https://stackoverflow.com/questions/39881371/is-there-a-way-to-create-a-new-variable-from-user-input-in-java
                            nameItem.add(itemName + " - $" + itemCost + "0");
                            System.out.println( );
                            System.out.println("You may enter the cost of another item.");
                        } else {
                            System.out.println("Rounded cost to nearest cent: $" + itemCost);
                            System.out.print("Enter the item name: ");
                            itemName = scan.nextLine();
                            // code is from https://stackoverflow.com/questions/39881371/is-there-a-way-to-create-a-new-variable-from-user-input-in-java
                            nameItem.add(itemName + " - $" + itemCost);
                            System.out.println( );
                            System.out.println("You may enter the cost of another item.");
                        }
                        itemCost = scan.nextDouble();
                        scan.nextLine();
                    }
                }
            }
            if (itemCost == -1){
                itemCost = 0.01;
                System.out.println("Total Cost Of Items: $" + totalCostOfItems);

                // calculates amounts based on entered costs
                double tip = (double) ((int) ((totalCostOfItems * ((double) percentTip / 100) + 0.005) * 100)) / 100;
                double tax = ((int)((totalCostOfItems * 0.08875) * 100) / 100.0);
                double totalBill = totalCostOfItems + tip;
                double costPerPerson = ((int)((totalCostOfItems / people) * 100)) /100.0;
                double taxPerPerson = ((int)(((tax / people) + 0.005) * 100) / 100.0);
                double tipPerPerson = ((int)(((tip / people) + 0.005) * 100) / 100.0);
                double totalCostPerP = ((int)(((costPerPerson + taxPerPerson + tipPerPerson) + 0.005) * 100) / 100.0);

                System.out.println( );

                // prints receipt border
                System.out.println("------------------------------------------------");
                System.out.println("                    ORDER #001                  ");

                System.out.println( );

                // prints name
                System.out.println("Name: " + name);

                // prints people
                System.out.println("Guests: " + people);

                // prints percentTip
                System.out.println("Tip Percentage: " + percentTip + "%");

                System.out.println( );

                // code is from https://stackoverflow.com/questions/10168066/how-to-print-out-all-the-elements-of-a-list-in-java
                nameItem.forEach(System.out::println);

                System.out.println( );

                // prints totalCostOfItems with two decimal places
                if (totalCostOfItems - 0.01 < ((int)(totalCostOfItems * 10)) / 10.0) {
                    System.out.println("Subtotal: $" + totalCostOfItems + "0");
                } else {
                    System.out.println("Subtotal: $" + totalCostOfItems);
                }

                // prints tax with two decimal places
                if (tax - 0.01 < ((int)(tax * 10)) / 10.0) {
                    System.out.println("Tax: $" + tax + "0");
                } else {
                    System.out.println("Tax: $" + tax);
                }

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

                System.out.println("WANT TO SPLIT THE BILL?!");

                // prints costPerPerson with two decimal places
                if (costPerPerson - 0.01 < ((int)(costPerPerson * 10)) / 10.0) {
                    System.out.println("Cost Per Person Without Tip: $" + costPerPerson + "0");
                } else {
                    System.out.println("Cost Per Person Without Tip: $" + costPerPerson);
                }

                // prints taxPerPerson with two decimal places
                if (taxPerPerson - 0.01 < ((int)(taxPerPerson * 10)) / 10.0) {
                    System.out.println("Tax Per Person: $" + taxPerPerson + "0");
                } else {
                    System.out.println("Tax Per Person: $" + taxPerPerson);
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

                System.out.println( );
                System.out.println("                    THANK YOU!                  ");

                // prints receipt border
                System.out.println("------------------------------------------------");
            }
        }


    }
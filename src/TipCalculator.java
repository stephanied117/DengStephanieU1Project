import java.util.Scanner;

    public class TipCalculator {
        public static void main(String [] args) {
            Scanner scan = new Scanner (System.in) ;
            System.out.print("Enter your name: ");
            String name = scan.nextLine();
            System.out.println("Welcome, " + name + "!");
            System.out.print("How many people are in your party? ");
            int people = scan.nextInt();
            System.out.println(people + " guests");
            System.out.print("What percent would you like to tip? ");
            int percentTip = scan.nextInt();
            System.out.println(percentTip + "% Tip");
            System.out.println("Please enter the cost of an item in dollars and cents. If you are done, enter -1. ");
            double itemCost = scan.nextDouble();
            double totalBill = 0;
            totalBill = totalBill + itemCost;
            if (itemCost > 0) {
                while (itemCost > 0) {
                    itemCost = scan.nextFloat();
                    totalBill = totalBill + itemCost;
                }
            } else {
                if (itemCost < 0) {
                    if (itemCost > -1) {
                        System.out.println("Invalid input amount.");
                        totalBill = (-1 * itemCost) + totalBill;
                        itemCost = 0.01;
                    }
                } else {
                    if (itemCost < -1) {
                        System.out.println("Invalid input amount.");
                        totalBill = (-1 * itemCost) + totalBill;
                        itemCost = 0.01;
                    }
                }
            }

            if (itemCost == -1) {
                totalBill = (-1 * itemCost) + totalBill;
                itemCost = 0.01;
                totalBill = ((int)((totalBill + 0.005) * 100)) / 100;
            }
            System.out.println("The total cost of your items are: $" + totalBill);
        }
    }

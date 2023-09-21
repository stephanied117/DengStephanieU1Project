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
            System.out.println("Please enter the cost of an item. If you are done, type -1. ");
            double itemCost = scan.nextDouble();
            double totalBill = 0;
            totalBill = totalBill + itemCost;
            while (itemCost > 0) {
                itemCost = scan.nextDouble();
                totalBill = totalBill + itemCost;
            }
            System.out.println("Your total is: $" + totalBill);
        }
    }

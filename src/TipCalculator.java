import java.util.Scanner;

    public class TipCalculator {
        public static void main(String [] args) {
            Scanner scan = new Scanner (System.in) ;
            System.out.print("Enter your name: ");
            String name = scan.nextLine();
            System.out.println("Welcome " + name);
            System.out.print("How many people are in your party? " );
            int people = scan.nextInt();
            System.out.println("Tip percentage: ");


        }
    }

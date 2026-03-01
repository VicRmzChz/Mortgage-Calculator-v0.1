import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // convert user strings
        int principalInt = 0;
        float interestRateFloat = 0;
        int periodInt = 0;

        // Loan moeny
        do {
            try {
                System.out.print("Principal: ");
                principalInt = Integer.parseInt(scanner.nextLine().trim());

                if (principalInt == 0){
                    System.out.println("(Principal) can't be zero");
                } else if (principalInt < 2000) {
                    System.out.println("Loan must be equal or higher to $2000");
                }
            }
            catch (NumberFormatException e){
                System.out.println("(Principal) is not a number");
            }
        } while (principalInt == 0 || principalInt < 2000);

        // interest
        do {
            try {
                System.out.print("Annual interest Rate: ");
                interestRateFloat = Float.parseFloat(scanner.nextLine().trim());

                if (interestRateFloat == 0){
                    System.out.println("(interest) can't be zero");
                } else if (interestRateFloat < 2) {
                    System.out.println("interest must be equal or higher to 2.0");
                }
            }
            catch (NumberFormatException e){
                System.out.println("(interest) is not a number");
            }

        } while(interestRateFloat == 0 || interestRateFloat < 2);

        //period
        do {
            try {
                System.out.print("period: ");
                periodInt = Integer.parseInt(scanner.nextLine().trim());

                if (periodInt == 0){
                    System.out.println("(period) can't be zero");
                } else if (periodInt < 2) {
                    System.out.println("periodInt must be equal or higher to 2");
                }
            }
            catch (NumberFormatException e){
                System.out.println("(period) is not a number");
            }
        } while (periodInt == 0 || periodInt < 2);


        // Interes
        int month = periodInt * 12;
        float totalInterest = ((interestRateFloat / 100)/12);
        float totalInterest2 = (float)Math.pow(1 + totalInterest, month) * totalInterest;
        float totalInterest3 = (float)Math.pow(1 + totalInterest, month) - 1;
        float total = principalInt * (totalInterest2 / totalInterest3);

        // Print out to user
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Mortgage: " + usFormat.format(total));
    }
}

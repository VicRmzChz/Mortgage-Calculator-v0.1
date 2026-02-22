import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Money borrow
        System.out.print("Principal: ");
        String principal = scanner.nextLine().trim();
        float principalFloat = Float.parseFloat(principal);

        // interest
        System.out.print("Annual interest Rate: ");
        String interestRate = scanner.nextLine().trim();
        float interestRateFloat = Float.parseFloat(interestRate);

        //period
        System.out.print("period: ");
        String period = scanner.nextLine().trim();
        int periodInt = Integer.parseInt(period);

        // Interes
        int month = periodInt * 12;
        float totalInterest = ((interestRateFloat / 100)/12);
        float totalInterest2 = (float)Math.pow(1 + totalInterest, month) * totalInterest;
        float totalInterest3 = (float)Math.pow(1 + totalInterest, month) - 1;
        float total = principalFloat * (totalInterest2 / totalInterest3);

        // Print out to user
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Mortgage: " + usFormat.format(total));
    }
}

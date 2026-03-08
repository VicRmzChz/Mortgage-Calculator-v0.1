import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // convert user strings
        String customerName = "";
        int principalInt = 0;
        float interestRateFloat = 0;
        int periodInt = 0;

        String[] customers = new String[0];
        String[] customersPayments = new String[0];

        // Borrowed money: ask the user to enter an amount that is $2000 or more,
        // check that the user's input is not zero and that the loan is equal to or
        // greater than $2000, as well as ensure that it is a number being entered; otherwise,
        // it will throw an error and continue asking the user to enter something valid.
        do {
            try {
                System.out.print("Enter Customer Name: ");
                customerName = scanner.nextLine().trim();

                if (customerName.isEmpty() || customerName == "") {
                    System.out.println("(Name) can't be Empty");
                } else if (customerName.matches("[A-Za-z]+")) {
                    System.out.println("Valid Name");
                } else{
                    System.out.println("Name must not have numbers");
                }
            } catch (NullPointerException  e) {
                System.out.println("Null value encountered.");
            }
        } while(customerName == null || customerName.isEmpty() || !customerName.matches("[A-Za-z]+"));


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
                    System.out.println("period must be equal or higher to 2");
                }
            }
            catch (NumberFormatException e){
                System.out.println("(period) is not a number");
            }
        } while (periodInt == 0 || periodInt < 2);


        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length - 1] = customerName;




        // Interes
        int month = periodInt * 12;
        float totalInterest = ((interestRateFloat / 100)/12);
        float totalInterest2 = (float)Math.pow(1 + totalInterest, month) * totalInterest;
        float totalInterest3 = (float)Math.pow(1 + totalInterest, month) - 1;
        float total = principalInt * (totalInterest2 / totalInterest3);

        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String totalCurrency = usFormat.format(total);


        // Print out to user

        System.out.println("Mortgage: " + totalCurrency);

        customersPayments = Arrays.copyOf(customersPayments, customersPayments.length + 1);
        customersPayments[customersPayments.length - 1] = totalCurrency;

        System.out.println(Arrays.toString(customers));
        System.out.println(Arrays.toString(customersPayments));
    }
}

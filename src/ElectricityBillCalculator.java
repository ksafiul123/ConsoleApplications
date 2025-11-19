import java.util.Scanner;

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total units consumed: ");
        double units = scanner.nextDouble();

        double bill = calculateBill(units);

        System.out.printf("Total Electricity Bill: %.2f Tk%n", bill);

        scanner.close();
    }

    public static double calculateBill(double units) {
        double bill = 0.0;

        if (units <= 75) {
            bill = units * 5.26;
        } else if (units <= 200) {
            bill = (75 * 5.26) + ((units - 75) * 7.20);
        } else if (units <= 300) {
            bill = (75 * 5.26) + (125 * 7.20) + ((units - 200) * 7.59);
        } else if (units <= 400) {
            bill = (75 * 5.26) + (125 * 7.20) + (100 * 7.59) + ((units - 300) * 8.02);
        } else if (units <= 600) {
            bill = (75 * 5.26) + (125 * 7.20) + (100 * 7.59) + (100 * 8.02) + ((units - 400) * 12.67);
        } else {
            bill = (75 * 5.26) + (125 * 7.20) + (100 * 7.59) + (100 * 8.02) + (200 * 12.67) + ((units - 600) * 14.61);
        }

        return bill;
    }
}

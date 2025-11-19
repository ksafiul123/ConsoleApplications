import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        double currentBalance = 500.0;
        Scanner input = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("Welcome to the Simple Console ATM!");
            System.out.println("Please select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            choice =  input.nextInt();

            switch (choice){

                case 1:
                    System.out.println("Your current balace is: "+currentBalance+ "taka");
                    break;

                case 2:
                    System.out.print("Enter amount to deposit:");
                    double deposit = input.nextDouble();
                    if(deposit<=0){
                        System.out.println("Invalid amount. Deposit must be positive");
                    }
                    else{
                        currentBalance+=deposit;
                        System.out.println("Successfully deposited "+deposit+" taka");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw:");
                    double withdraw = input.nextDouble();
                    if(withdraw<=0){
                        System.out.println("Invalid amount. Withdrawal must be positive");
                    }
                    else if(withdraw>100){
                        System.out.println("You can only withdraw up to 100 taka per transaction");
                    }
                    else if(withdraw>currentBalance){
                        System.out.println("Insufficient funds!");
                    }
                    else{
                        currentBalance-=withdraw;
                        System.out.println("Successfully withdrew "+withdraw+" taka");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM! Goodbye.");
                    input.close();
                    System.exit(1);

                default:
                    System.out.println("Invalid selection. Please try again");
            }
        }
    }
}

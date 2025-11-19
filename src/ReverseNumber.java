import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int number = 123;
        int reverse=0;



        while(number!=0){
            int remainder = number%10;
            reverse=reverse*10+ remainder;
            number=number/10;

        }
        System.out.println("Reversed number is "+reverse);

    }
}

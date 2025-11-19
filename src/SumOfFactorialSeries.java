import java.util.Scanner;

public class SumOfFactorialSeries {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n= input.nextInt();
        int sum= 0;

        for (int i=1;i<=n;i++){
            int fact=1;
            for(int j=1;j<=i;j++){
                fact=fact*j;
            }
            sum = sum+fact;
        }
        System.out.println("Sum of fibonacci series upto "+n+" terms is "+sum);
        input.close();
    }
}

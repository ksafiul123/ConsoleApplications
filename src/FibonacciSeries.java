import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of terms(n):");
    int n = input.nextInt();

    System.out.println("Fibonacci Series upto "+n+" terms");
    int a=0,b=1,c;
    for(int i=1;i<=n;i++){
        System.out.print(a+" ");
        c=a+b;
        a=b;
        b=c;
    }
        input.close();
    }
}

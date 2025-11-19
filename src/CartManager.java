import java.util.Scanner;
import java.util.UUID;

class CartItem{
    private final String productId;
    private final String name;
    private final double price;
    private int quantity;

    public CartItem(String name, double unitPrice, int quantity){

        if(unitPrice<=0){
            unitPrice = 1.0;
        }

        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.price = unitPrice;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void increment(){
        quantity++;
    }

    public String getName(){
        return name;
    }

    public double lineTotal(){
        return price * quantity;
    }

    public String toString(){
        return name + " | Price: " + price + " | Qty: " + quantity + " | Total: " + lineTotal();
    }

    public void decrement(){
        if (quantity > 1){
            quantity--;
        }
    }

}

public class CartManager {

    private static void addToCart(CartItem item){
        if(item.getQuantity()==0){
            item.setQuantity(1);
        } else {
            item.increment();
        }
        System.out.println(item.getQuantity() + " item added. Quantity: " + item.getQuantity());
    }

    private static void printCart(CartItem item1, CartItem item2, CartItem item3 ){
        if(item1.getQuantity() == 0 && item2.getQuantity() == 0 && item3.getQuantity() == 0 ){
            System.out.println("Cart is empty!");
        } else {
            if (item1.getQuantity() > 0) System.out.println(item1);
            if (item2.getQuantity() > 0) System.out.println(item2);
            if (item3.getQuantity() > 0) System.out.println(item3);
        }
        System.out.println("---------------------------------------");

    }

    private static CartItem selectItem(int lastSelected, CartItem item1, CartItem item2, CartItem item3, Scanner sc){
//        if (lastSelected == 1) return item1;
//        if (lastSelected == 2) return item2;
//        if (lastSelected == 3) return  item3;

        System.out.print("Choose item (1=Egg, 2=Milk, 3=Noodles): ");
        if(!sc.hasNextInt()){
            sc.nextLine();
            System.out.println("Invalid input:");
            return null;
        }
        int choice = sc.nextInt();
        switch(choice){
            case 1: return item1;
            case 2: return item2;
            case 3: return item3;
            default:
                System.out.println("Invalid selection:");
                return null;

        }

    }

    private static void incrementItem(int lastSelected, CartItem item1, CartItem Item2, CartItem Item3, Scanner sc){
        CartItem item = selectItem(lastSelected, item1, Item2, Item3, sc);
        if(item1!=null){
            item.increment();
            System.out.println(item.getName() + " incremented. Quantity: " + item.getQuantity());
        }
    }

    private static void decrementItem(int lastSelected, CartItem item1, CartItem item2, CartItem item3, Scanner sc){
        CartItem item = selectItem(lastSelected, item1, item2, item3, sc);
        if (item!= null){
            int before = item.getQuantity();
            item.decrement();
                if(before == item.getQuantity()){
                    System.out.println("Quantity cannot be less than 1");
                } else {
                    System.out.println(item.getName() + "decremented. Quantity: " + item.getQuantity() );
                }
        }
    }

        private static boolean isEmpty(CartItem item1, CartItem item2, CartItem item3){
            if (item1.getQuantity() == 0 && item2.getQuantity() == 0 && item3.getQuantity() == 0){
                return true;
            }
            return false;
        }

    private static void printTotal(CartItem item1, CartItem item2, CartItem item3){
        if(isEmpty(item1, item2, item3)){
            System.out.println("First Add Something to Cart!");
        } else {
            double total = item1.lineTotal() + item2.lineTotal() + item3.lineTotal();
            System.out.println("Total Payable Amount: " + total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CartItem egg = new CartItem("Egg",10.0,0);
        CartItem milk = new CartItem("Milk",20.0,0);
        CartItem noodles = new CartItem("Noodles",30.0,0);

        int choice = -1;
        int lastSelected = 0;

        while(choice!=0){
            System.out.println("\n=====MENU=====\n");
            System.out.println("1 - Add Egg (10)");
            System.out.println("2 - Add Milk (20)");
            System.out.println("3 - Add Noodles (30)");
            System.out.println("4 - Print Cart");
            System.out.println("5 - Increment Quantity (+)");
            System.out.println("6 - Decrement Quantity (-)");
            System.out.println("7 - Print Total");
            System.out.println("0 - Exit");
            System.out.println("===========");
            System.out.print("Enter choice: ");

            if(!sc.hasNextInt()){
                System.out.println("Invalid input. Try again.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    addToCart(egg);
                    lastSelected = 1;
                    break;

                case 2:
                    addToCart(milk);
                    lastSelected = 2;
                    break;

                case 3:
                    addToCart(noodles);
                    lastSelected = 3;
                    break;

                case 4:
                    //print cart item
                    printCart(egg, milk, noodles);
                    break;

                case 5:
                    //increment quantity
                        incrementItem(lastSelected, egg, milk, noodles, sc);
                        break;

                case 6:
                    // decrement quantity
                        decrementItem(lastSelected, egg, milk, noodles, sc);
                        break;

                case 7:
                    //print total
                        printTotal(egg, milk, noodles);
                        break;

                case 0:
                    printCart(egg, milk, noodles);
                    printTotal(egg, milk, noodles);
                    System.out.println("Thank you! Exiting....");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again:");

            }

        }


    }
}

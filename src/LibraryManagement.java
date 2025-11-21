class Book{
    String title;
    String author;
    double price;

    public Book(double price, String author, String title) {
        this.price = price;
        this.author = author;
        this.title = title;
    }

    public void displayBook(){
        System.out.println("Name of the book is: " + this.title);
        System.out.println("Author of the book is: " + this.author);
        System.out.println("Price of the book is: " + this.price);
        if (price>500){
            System.out.println("Category: Expensive");
        } else {
            System.out.println("Catergory: Affordable");
        }

    }

}

class Library{
    static Book [] books;
    static int count = 0;

    public Library(int size) {
        books = new Book[size];
    }

    static void addBook(Book b){
        if (count < books.length){
            books [count] = b;
            count++;
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    static void displayAllBooks(){
        System.out.println("-------------Book List------------");
        for(int i = 0; i < count; i++){
            books[i].displayBook();
        }
    }

}

public class LibraryManagement {
    public static void main(String[] args) {
        Library.books = new Book[5];

        Book b1 = new Book(400, "safi","Springboot");
        Book b2 = new Book(500, "anam","Java");
        Book b3 = new Book(600, "fahim","Python");

        Library.addBook(b1);
        Library.addBook(b2);
        Library.addBook(b3);

        Library.displayAllBooks();



    }


}

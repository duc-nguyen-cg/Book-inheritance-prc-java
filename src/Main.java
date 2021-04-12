import java.util.Scanner;
import java.lang.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int size = 10;

    public static Book addBook(int index, Book[] library){
        System.out.println("Enter code for book "+(index+1)+": ");
        int bookCode = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name for book "+(index+1)+": ");
        String name = sc.nextLine();
        System.out.println("Enter author for book "+(index+1)+": ");
        String author = sc.nextLine();
        System.out.println("Enter price for book "+(index+1)+": ");
        double price = sc.nextDouble();
        sc.nextLine();

        if (library[index] instanceof ProgrammingBook){
            System.out.println("Enter language for book "+(index+1)+": ");
            String language = sc.nextLine();
            System.out.println("Enter framework for book "+(index+1)+": ");
            String framework = sc.nextLine();

            return new ProgrammingBook(bookCode, name, author, price, language, framework);
        } else {
            System.out.println("Enter category for book "+(index+1)+": ");
            String category = sc.nextLine();

            return new FictionBook(bookCode, name, author, price, category);
        }
    }

    public static double sumPrice(Book[] library){
        double sum = 0;
        for (Book book: library){
            sum += book.getPrice();
        }
        return sum;
    }

    public static void displayLibrary(Book[] library){
        //print library
        for (Book book : library){
            System.out.println(book);
        }
    }

    public static Book[] sortByBookCode(Book[] library){
        Book[] newLibrary = new Book[size];
        System.arraycopy(library, 0, newLibrary, 0, size);

        for (int i = 0; i < size; i++){
            for (int j = i+1; j < size; j++){
                if (newLibrary[i].getBookCode() > newLibrary[j].getBookCode()){
                    Book temp = newLibrary[j];
                    newLibrary[j] = newLibrary[i];
                    newLibrary[i] = temp;
                }
            }
        }
        return newLibrary;
    }

    public static void main(String[] args){
        Book[] library = new Book[size];
        //set the type of books in library
        for (int i = 0; i < size/2; i++){
            library[i] = new ProgrammingBook();
        }
        for (int i = size/2; i < size; i++){
            library[i] = new FictionBook();
        }

        //init books
        for (int i = 0; i < size; i++){
            library[i] = addBook(i, library);
        }
        displayLibrary(library);

        //compute total price of books
        System.out.println("Total price = "+sumPrice(library));


        //count programming books about Java
        int count = 0;
        for (Book book: library){
            if (book instanceof ProgrammingBook){
                if (((ProgrammingBook) book).getLanguage().equals("Java")){
                    count ++;
                }
            }
        }
        System.out.println("Number of programming books about Java = "+count);

        //sort by book code
        displayLibrary(sortByBookCode(library));
    }
}

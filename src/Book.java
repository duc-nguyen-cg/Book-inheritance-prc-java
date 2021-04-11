public class Book {
    private String name = "", author = "";
    private int bookCode = 1;
    private double price = 80.0;

    public Book(){
    }

    public Book(int bookCode, String name, String author, double price){
        this.bookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return bookCode + ". " + name + "  -  " + author + "  -  " + price;
    }
}

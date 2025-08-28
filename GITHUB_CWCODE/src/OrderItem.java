public class OrderItem {
    private String bookTitle;
    private String author;
    private int quantity;
    private int index;

    public OrderItem(String bookTitle, String author, int quantity, int index) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.quantity = quantity;
        this.index = index;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIndex() {
        return index;
    }
}

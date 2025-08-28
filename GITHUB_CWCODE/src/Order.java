public class Order {
    private int orderId, size = 0;
    private static final int MAX = 10;
    private OrderItem[] items = new OrderItem[MAX];

    public Order(int orderId) { this.orderId = orderId; }
    public int getOrderId() { return orderId; }
    public int getSize() { return size; }
    public OrderItem[] getItems() { return items; }

    public void addItem(OrderItem item) {
        for (int i = 0; i < size; i++) {
            if (items[i].getIndex() == item.getIndex()) {
                items[i] = new OrderItem(
                        items[i].getBookTitle(),
                        items[i].getAuthor(),
                        items[i].getQuantity() + 1,
                        items[i].getIndex()
                );
                return;
            }
        }
        if (size < MAX) items[size++] = item;
        else System.out.println("Cannot add more books");
    }

    public void printItems() {
        System.out.println("Order #" + orderId);
        for (int i = 0; i < size; i++)
            System.out.println(" - [" + items[i].getIndex() + "] "
                    + items[i].getBookTitle() + " by "
                    + items[i].getAuthor() + " (qty: " + items[i].getQuantity() + ")");
    }
}

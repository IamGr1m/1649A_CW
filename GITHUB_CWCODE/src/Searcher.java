public class Searcher {
    public static int linearSearch(Order[] orders, int orderId) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null && orders[i].getOrderId() == orderId) {
                return i;
            }
        }
        return -1;
    }
}

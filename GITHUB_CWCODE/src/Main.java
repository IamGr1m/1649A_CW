import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] books = new String[1000][];
        int bookCount = 0;

        // CSV
        try (BufferedReader br = new BufferedReader(new FileReader("BooksDatasetClean.csv"))) {
            String line;
            while ((line = br.readLine()) != null && bookCount < books.length) {
                books[bookCount++] = line.split(",");
            }
        }

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Queue<Order> orderQueue = new Queue<>(100);
        int orderCounter = 1;

        //Create Orders
        while (true) {
            System.out.print("\nCreate Order #" + orderCounter + "? (yes/no): ");
            if (!console.readLine().trim().equalsIgnoreCase("yes")) break;

            Order order = new Order(orderCounter);

            while (true) {
                System.out.print("Enter book index (1-" + (bookCount - 1) + ", 0 to stop): ");
                int idx = Integer.parseInt(console.readLine());
                if (idx == 0) break;
                if (idx < 0 || idx >= bookCount) { System.out.println("Invalid index."); continue; }

                String[] row = books[idx];
                String title = row.length > 0 ? row[0] : "Unknown Title";
                String author = row.length > 1 ? row[1] : "Unknown Author";
                order.addItem(new OrderItem(title, author, 1, idx));
            }
            orderQueue.enqueue(order);
            orderCounter++;
        }

        // Add books
        Order[] processed = new Order[100];
        int processedCount = 0;

        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue();
            System.out.println("\nProcessing Order #" + order.getOrderId());
            order.printItems();

            Sorter.insertionSort(order.getItems(), order.getSize());
            System.out.println("Sorted Items:");
            order.printItems();
            processed[processedCount++] = order;
        }

        //Search Order
        System.out.print("\nEnter order number to search: ");
        int orderId;
        try { orderId = Integer.parseInt(console.readLine()); }
        catch (NumberFormatException e) { System.out.println("Invalid."); return; }

        int index = Searcher.linearSearch(processed, orderId);
        if (index != -1) {
            System.out.println("\nFound Order #" + processed[index].getOrderId());
            processed[index].printItems();
        } else {
            System.out.println("No order found.");
        }
    }
}

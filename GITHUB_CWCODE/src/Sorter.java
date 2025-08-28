public class Sorter {
    public static void insertionSort(OrderItem[] items, int size) {
        for (int i = 1; i < size; i++) {
            OrderItem key = items[i];
            int j = i - 1;

            while (j >= 0 && items[j].getIndex() > key.getIndex()) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }
    }
}

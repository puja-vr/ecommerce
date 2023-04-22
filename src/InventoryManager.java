public class InventoryManager {
    // InventoryManager() {
    //     XX object41 = (XX) Class.forName(
    //     "in.bench.resources.reflection.XX").getConstructor()
    //     .newInstance();
    // }

    String pid;
    int quantity;

    void addStock(int n) {
        quantity+=n;
    }
    
    void minusStock(int n) {
        quantity-=n;
    }
}

import java.nio.file.*;
import java.util.*;

public class InventoryManager {
    Map<String,Integer> stock;
       
    InventoryManager() throws Exception {
        stock = new HashMap<>();
        Path file = Paths.get("/home/puja-pt6721/Drive/ecommerce/src/products/Load.txt");
        List<String> filenames = Files.readAllLines(file);
        for (String product : filenames) {
            stock.put(product,5);
        }
    }
    
    boolean inventoryCheck(String pid,int n) throws Exception {
        for (String product : stock.keySet()) {
            int quantity=stock.get(product);
            if(product.contains(pid) && n<=quantity) {
                stock.replace(product, quantity-n);
                System.out.println("Remaining stock = "+stock.get(product));
                return true;
            } 
        }
        return false;
    }
}

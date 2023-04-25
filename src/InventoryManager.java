import java.nio.file.*;
import java.util.*;

import categories.Product;

public class InventoryManager {
    private static InventoryManager im;
    public static InventoryManager getObject() throws Exception {
        if(im == null) {
            im = new InventoryManager();
        }
        return im;
    }
    Map<String,Product> stock;
       
    public InventoryManager() throws Exception {
        stock = new HashMap<>();
        Path file = Paths.get("/home/puja-pt6721/Drive/ecommerce/src/products/Load.txt");
        List<String> filenames = Files.readAllLines(file);
        for (String product : filenames) {
            Product obj = (Product) Class.forName(product).getConstructor().newInstance();
            stock.put(product,obj);
        }
    }
    
    void printInventory() {
        System.out.println("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Welcome to E-commerce site!~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        Formatter fmt = new Formatter();  
        fmt.format("%10s |%15s |%35s |%15s |%15s |%10s\n","PID","Name","Description","Category","Subcategory","Quantity");  
        fmt.format("--------------------------------------------------------------------------------------------------------------\n");
        for (String product : stock.keySet()) {
            Product prod = stock.get(product);
            fmt.format("%10s |%15s |%35s |%15s |%15s |%10s\n",prod.getPid(),prod.getName(),prod.getDesc(),prod.getCat(),prod.getSubcat(),prod.getQuantity()); 
        }  
        System.out.println(fmt);
    }

    boolean inventoryCheck(String pid,int n) throws Exception {
        for (String product : stock.keySet()) {
            int quantity=stock.get(product).getQuantity();
            if(product.contains(pid) && n<=quantity) {
                stock.get(product).setQuantity(quantity-n);
                System.out.println("Remaining stock = "+stock.get(product).getQuantity());
                return true;
            } 
        }
        return false;
    }
}

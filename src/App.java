import java.nio.file.*;
import java.util.*;

import categories.Product;

public class App {
    public static void main(String[] args) throws Exception {

        Path file = Paths.get("/home/puja-pt6721/Drive/ecommerce/src/products/Load.txt");
        List<String> filenames = Files.readAllLines(file);        
        Scanner sc=new Scanner(System.in);
        InventoryManager im=new InventoryManager();
        CartManager cm=new CartManager();

        while(true) {
            System.out.println("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ Welcome to E-commerce site!~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
            Formatter fmt = new Formatter();  
            fmt.format("%10s |%15s |%35s |%15s |%15s\n","PID","Name","Description","Category","Subcategory");  
            fmt.format("--------------------------------------------------------------------------------------------------\n");
            for (String product : filenames) {
                Product prod = (Product) Class.forName(product).getConstructor().newInstance();
                fmt.format("%10s |%15s |%35s |%15s |%15s\n",prod.getPid(),prod.getName(),prod.getDesc(),prod.getCat(), prod.getSubcat()); 
            }  
            System.out.println(fmt);

            System.out.println("1. Place order");
            System.out.println("2. View carts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch=sc.nextInt();

            switch(ch) {
                case 1:
                    Map<String,Integer> items=new HashMap<>();
                    System.out.println("\nTo stop -> enter \"q\"");
                    while(true) {
                        System.out.print("Enter PID and quantity: ");
                        String pid=sc.next();
                        if(pid.equals("q") || pid.equals("Q")) break;
                        int quantity=sc.nextInt();
            
                        if(im.inventoryCheck(pid,quantity)) items.put(pid, quantity);  
                        else System.out.println("Insufficient stock OR Invalid PID!");
                    }
                    cm.addToCart(items);
                    break;
                case 2:
                    cm.printCarts();
                    break;
                case 3: 
                    sc.close();
                    System.exit(1);
            }
        }
    }
}

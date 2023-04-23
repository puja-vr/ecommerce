import java.util.*;

class Cart {
    Map<String,Integer> items;  
}

public class CartManager {
    List<Cart> carts;

    CartManager() {
        carts=new ArrayList<Cart>();
    }

    void addToCart(Map<String,Integer> items) {
        Cart c=new Cart();
        c.items=new HashMap<>();
        c.items.putAll(items);
        carts.add(c);
        System.out.println("Items are added to your cart!");
    }

    void printCarts() {
        int i=1;
        for(Cart c:carts) {
            System.out.println("\nCart "+(i++));
            Formatter fmt = new Formatter();  
            fmt.format("%10s |%12s\n","PID","Quantity");  
            fmt.format("------------------------\n");
            c.items.forEach((key,value) -> 
            fmt.format("%10s |%12s\n",key,value)); 
            System.out.println(fmt);  
        }
    }
}

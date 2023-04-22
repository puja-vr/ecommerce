import java.util.*;

public class CartManager {
    List<Cart> carts;

    void addToCart(Map<String,Integer> items) {
        Cart c=new Cart();
        c.items.putAll(items);
    }
}

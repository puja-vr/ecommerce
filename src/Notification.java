import java.util.*;

abstract class Notification {
    public abstract void setNextChain(Notification nextChain);
    public abstract void newOrder(String pid,int quantity) throws Exception;
}

class InventoryChange extends Notification {
    InventoryManager im;
    private Notification chain;
	
	@Override
	public void setNextChain(Notification nextChain) {
		this.chain=nextChain;
	}
 
    public InventoryChange() throws Exception {
       this.im = InventoryManager.getObject();
    }

    public void newOrder(String pid,int quantity) throws Exception {
        if(pid.equalsIgnoreCase("q") || pid.equalsIgnoreCase("Q")) 
            this.chain.newOrder(pid, quantity);
        else if(im.inventoryCheck(pid,quantity)) 
            this.chain.newOrder(pid, quantity);
        else System.out.println("Insufficient stock OR Invalid PID!");
        
    }
}

class CartChange extends Notification {
    CartManager cm;
    Map<String,Integer> items;  
    private Notification chain;
	
	@Override
	public void setNextChain(Notification nextChain) {
		this.chain=nextChain;
	}
 
    public CartChange() throws Exception {
       this.cm = CartManager.getObject();
       items=new HashMap<>();
    }

    public void newOrder(String pid,int quantity) throws Exception {
        if(pid.equalsIgnoreCase("q")) {
            cm.addToCarts(items);
            items.clear();
        }
        else {
            items.put(pid, quantity);
        }
    }
}
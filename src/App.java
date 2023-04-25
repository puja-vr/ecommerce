import java.util.*;

public class App {
    private Notification c1;

	public App() throws Exception {
		this.c1 = new InventoryChange();
		Notification c2 = new CartChange();
		c1.setNextChain(c2);
	}
    public static void main(String[] args) throws Exception {
   
        App myapp = new App();
        Scanner sc=new Scanner(System.in);
        InventoryManager im=InventoryManager.getObject();
        CartManager cm=CartManager.getObject();

        while(true) {
            im.printInventory();

            System.out.println("1. Place order");
            System.out.println("2. View carts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch=sc.nextInt();

            switch(ch) {
                case 1:
                    System.out.println("\nTo stop -> enter \"q\"");
                    while(true) {
                        System.out.print("Enter PID and quantity: ");
                        String pid=sc.next();
                        int quantity=0;
                        if(!(pid.equalsIgnoreCase("q")))
                            quantity=sc.nextInt();
                        
                        myapp.c1.newOrder(pid,quantity);
                        if(pid.equalsIgnoreCase("q")) break;
                    }
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

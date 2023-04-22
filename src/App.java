import products.*;

public class App {
    public static void main(String[] args) throws Exception {
        Iphone14 obj = (Iphone14) Class.forName(
        "products.Iphone14").getConstructor()
        .newInstance();
        System.out.println(obj.getPid());
        System.out.println(obj.getName());
        System.out.println(obj.getDesc());
        System.out.println(obj.getCat());
        System.out.println(obj.getSubcat());
    }
}

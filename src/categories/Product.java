package categories;

abstract class Electronics extends Product {
    Electronics() {
        this.category="Electronics";
    }
}

abstract class Food extends Product {
    Food() {
        this.category="Food";
    }
}

abstract class Clothing extends Product {
    Clothing() {
        this.category="Clothing";
    }
}

public abstract class Product {
    protected String pid;
    protected String name;
    protected String description;
    protected String category;
    protected String subcat;
    protected int quantity;

    public String getPid() {
        return this.pid;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.description;
    }

    public String getCat() {
        return this.category;
    }

    public String getSubcat() {
        return this.subcat;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int n) {
        this.quantity=n;
    }
}

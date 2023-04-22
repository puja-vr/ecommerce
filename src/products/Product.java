package products;

abstract class Product {
    String pid;
    String name;
    String description;
    String category;
    String subcat;

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
}

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

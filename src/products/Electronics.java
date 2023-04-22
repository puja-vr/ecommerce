package products;

abstract class Mobile extends Electronics {
    Mobile() {
        this.subcat="Mobile";
    }
}

abstract class Laptop extends Electronics {
    Laptop() {
        this.subcat="Laptop";
    }
}

abstract class Charger extends Electronics {
    Charger() {
        this.subcat="Charger";
    }
}

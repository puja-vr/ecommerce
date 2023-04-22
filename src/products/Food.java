package products;

abstract class Tiffin extends Food {
    Tiffin() {
        this.subcat="Tiffin";
    }
}

abstract class Rice extends Food {
    Rice() {
        this.subcat="Rice";
    }
}

abstract class Breads extends Food {
    Breads() {
        this.subcat="Breads";
    }
}

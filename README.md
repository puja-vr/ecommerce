Folder `src` contains all source files.

### Class Hierarchy:
- Product
    - Electronics
        - Mobile
        - Laptop
        - Charger
    - Food
        - Tiffin
        - Rice
        - Breads
    - Clothing
        - Shirt
        - Pants
        - Salwar
- Notification
    - InventoryChange
    - CartChange
- InventoryManager
- CartManager
- Cart
- App -> has the main function

### Description:
- The app shows all the products with it's details in a table format.
- A menu is shown with 3 options.
    - Place order
    - View carts
    - Exit
- Place order:
    - Reduces the quantity from stock.
    - Adds all items to a new cart.
- View carts:
    - Prints all the carts created.

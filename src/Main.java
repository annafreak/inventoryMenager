 class Product {
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private String supplierEmail;

    public Product(String name, String category, double price, int stockQuantity, String supplierEmail) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.supplierEmail = supplierEmail;
    }

    public void restock(int quantity) {
        stockQuantity += quantity;
        System.out.println("Uzupełniono zapasy o " + quantity + ". Nowa ilość: " + stockQuantity + ".");
    }

    public void sell(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            System.out.println("Sprzedano " + quantity + ". Pozostało w magazynie: " + stockQuantity + ".");
        } else {
            System.out.println("Niewystarczająca ilość w magazynie!");
        }
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }
}

 class InventoryManager extends Product {
    private String department;
    private int managedProductsCount;
    private boolean isLoggedIn;

    public InventoryManager(String name, String category, double price, int stockQuantity, String supplierEmail, String department) {
        super(name, category, price, stockQuantity, supplierEmail);
        this.department = department;
        this.managedProductsCount = 0;
        this.isLoggedIn = false;
    }

    public void logIn() {
        isLoggedIn = true;
        System.out.println("Menedżer zalogowany.");
    }

    public void logOut() {
        isLoggedIn = false;
        System.out.println("Menedżer wylogowany.");
    }

    public void assignProduct() {
        managedProductsCount++;
        System.out.println("Przydzielono produkt. Liczba zarządzanych produktów: " + managedProductsCount);
    }

    public void viewReports() {
        System.out.println("Przeglądanie raportów...");
    }

    public void displayManagerData() {
        System.out.println("Dział: " + department);
        System.out.println("Zarządzanych produktów: " + managedProductsCount);
        System.out.println("Zalogowany: " + (isLoggedIn ? "tak" : "nie"));
    }
}

 class Application {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager("Laptop", "Elektronika", 2999.99, 10, "supplier@example.com", "IT");
        manager.logIn();
        manager.assignProduct();
        manager.displayManagerData();
        manager.sell(3);
        manager.restock(5);
        manager.displayManagerData();
        manager.logOut();
    }
}


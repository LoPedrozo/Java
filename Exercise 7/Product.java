import java.util.Scanner;

public class Product {
    public static  void print(String p){
        System.out.print(p);

    }
    public static  void println(String p){
        System.out.println(p);

    }
    private String name;
    private int codeP;
    private int stock;
    private float price;

    public Product(String name, int codeP, int stock, float price) {
        this.name = name;
        this.codeP = codeP;
        this.stock = stock;
        this.price = price;
    }

    public static Product addProduct(Scanner scanner) {
        println("Enter the product name:");
        String name = scanner.nextLine();

        println("Enter the product code:");
        int codeP = scanner.nextInt();

        println("Enter the stock quantity:");
        int stock = scanner.nextInt();
        if (stock < 0) {
            println("Invalid stock quantity! Setting to 0.");
            stock = 0;
        }

        println("Enter the price:");
        float price = scanner.nextFloat();
        scanner.nextLine();

        return new Product(name,codeP, stock, price);
    }

    public void updateProduct(Scanner scanner) {
        println("Updating product: " + name);


        println("New name (Press ENTER to keep the current name):");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            this.name = newName;
        }


        println("New product code (Press ENTER to keep current):");
        String newCode = scanner.nextLine();
        if (!newCode.isEmpty()) {
            this.codeP = Integer.parseInt(newCode);
        }


        println("New stock quantity (Press ENTER to keep current):");
        String newStock = scanner.nextLine();
        if (!newStock.isEmpty()) {
            this.stock = Integer.parseInt(newStock);
        }


        println("New price (Press ENTER to keep current):");
        String newPrice = scanner.nextLine();
        if (!newPrice.isEmpty()) {
            this.price = Float.parseFloat(newPrice);
        }

        println("Product updated successfully!");
    }



    public void displayInfo() {
        println("\n=== PRODUCT DETAILS ===");
        println("Name: " + name);
        println("Product Code: " + codeP);
        println("Stock Quantity: " + stock);
        println("Price: $" + price);
        println("----------------------------");
    }

    public int getcodeP() {
        return codeP;
    }
}

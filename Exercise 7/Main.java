import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static  void print(String p){
        System.out.print(p);

    }
    public static  void println(String p){
        System.out.println(p);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        println("WELCOME TO THE MARKET MANAGEMENT SYSTEM");
        println("--------------------------------------");

        while (true) {
            println("""
                    [0] ADD PRODUCT
                    [1] UPDATE PRODUCT INFORMATION
                    [2] REMOVE PRODUCT
                    [3] EXIT
                    [4] VIEW STOCK
                    """);

            print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    Product newProduct = Product.addProduct(scanner);
                    products.add(newProduct);
                    println("Product added successfully!");
                    break;

                case "1":
                    if (products.isEmpty()) {
                        println("No products registered to update.");
                    } else {
                        print("Enter the product code to update: ");
                        int searchcodeP = scanner.nextInt();
                        scanner.nextLine();

                        boolean found = false;
                        for (Product product : products) {
                            if (product.getcodeP() == (searchcodeP)) {
                                product.updateProduct(scanner);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            println("Product not found.");
                        }
                    }
                    break;

                case "2":
                    if (products.isEmpty()) {
                        println("No products registered to remove.");
                    } else {
                        print("Enter the product code to remove: ");
                        int searchcodeP = scanner.nextInt();
                        scanner.nextLine();

                        boolean removed = products.removeIf(product -> product.getcodeP() == searchcodeP );

                        if (removed) {
                            println("Product removed successfully!");
                        } else {
                           println("Product not found.");
                        }
                    }
                    break;

                case "3":
                    println("Exiting the system...");
                    scanner.close();
                    return;

                case "4":
                    if (products.isEmpty()) {
                        println("No products in stock.");
                    } else {
                        for (Product product : products) {
                            product.displayInfo();
                        }
                    }
                    break;

                default:
                    println("Invalid option. Please try again.");
            }
        }
    }
}

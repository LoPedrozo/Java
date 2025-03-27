import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void print(String p){
        System.out.print(p);

    }
    public static void println(String p){
        System.out.println(p);

    }
    private static List<pizza> menu = new ArrayList<>();
    private static List<order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadPizzas();
        menuSystem();
    }

    private static void loadPizzas() {
        menu.add(new pizza("Margherita", 10.0f, "Tomato, Mozzarella, Basil"));
        menu.add(new pizza("Pepperoni", 12.0f, "Pepperoni, Mozzarella, Tomato Sauce"));
        menu.add(new pizza("Hawaiian", 11.5f, "Ham, Pineapple, Cheese"));
    }

    private static void menuSystem() {
        while (true) {
            println("\n1. Place Order\n2. Cancel Order\n3. View Orders\n4. Generate Report\n5. Exit");
            print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: placeOrder(); break;
                case 2: cancelOrder(); break;
                case 3: viewOrders(); break;
                case 4: generateReport(); break;
                case 5: println("Exiting..."); return;
                default: println("Invalid option! Try again.");
            }
        }
    }

    private static void placeOrder() {
        List<pizza> selectedPizzas = new ArrayList<>();
        String size;
        String address;

        while (true) {
            println("\nAvailable Pizzas:");
            for (int i = 0; i < menu.size(); i++) {
                println((i + 1) + ". " + menu.get(i));
            }
            System.out.print("Choose a pizza (or 0 to finish): ");
            int pizzaChoice = scanner.nextInt();
            scanner.nextLine();

            if (pizzaChoice == 0) break;
            if (pizzaChoice < 1 || pizzaChoice > menu.size()) {
               println("Invalid choice!");
                continue;
            }

            selectedPizzas.add(menu.get(pizzaChoice - 1));
        }

        if (selectedPizzas.isEmpty()) {
            println("No pizzas selected. Order canceled.");
            return;
        }

        System.out.print("Choose size (small/medium/large): ");
        size = scanner.nextLine();

        System.out.print("Enter delivery address: ");
        address = scanner.nextLine();

        order newOrder = new order(selectedPizzas, size, address);
        orders.add(newOrder);
        println("Order placed successfully!\n" + newOrder);
    }

    private static void cancelOrder() {
        System.out.print("Enter Order ID to cancel: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        boolean removed = orders.removeIf(order -> order.getOrderId() == orderId);
        if (removed) {
            println("Order canceled successfully.");
        } else {
            println("Order ID not found.");
        }
    }

    private static void viewOrders() {
        if (orders.isEmpty()) {
            println("No orders placed yet.");
            return;
        }
        for (order order : orders) {
            System.out.println(order);
        }
    }

    private static void generateReport() {
        if (orders.isEmpty()) {
            println("No orders placed yet.");
            return;
        }
        double total = orders.stream().mapToDouble(order::getPrice).sum();
        double average = total / orders.size();
        println("Total Orders: " + orders.size());
        System.out.printf("Average Order Price: $%.2f\n", average);
    }
}

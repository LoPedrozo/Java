import java.util.List;

class order {
    private static int orderCounter = 1;
    private int orderId;
    private List<pizza> pizzas;
    private String size;
    private double price;
    private String address;

    public order(List<pizza> pizzas, String size, String address) {
        this.orderId = orderCounter++;
        this.pizzas = pizzas;
        this.size = size;
        this.address = address;
        this.price = calculateTotalPrice(size, pizzas);
    }

    private double calculateTotalPrice(String size, List<pizza> pizzas) {
        double total = 0;
        for (pizza pizza : pizzas) {
            switch (size.toLowerCase()) {
                case "medium":
                    total += pizza.getPrice() * 1.2;
                    break;
                case "large":
                    total += pizza.getPrice() * 1.5;
                    break;
                default:
                    total += pizza.getPrice();
            }
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Pizzas:\n");
        for (pizza pizza : pizzas) {
            sb.append("  - ").append(pizza).append("\n");
        }
        sb.append("Size: ").append(size).append("\n");
        sb.append("Price: $").append(price).append("\n");
        sb.append("Address: ").append(address);
        return sb.toString();
    }
}
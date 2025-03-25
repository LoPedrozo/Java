import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void println(String p) {
        System.out.println(p);
    }

    public static void print(String p) {
        System.out.print(p);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();

        while (true) {
            print("Enter a Brand for your vehicle (or 'next' to show the options): ");
            String brand = scanner.nextLine();
            if (brand.equalsIgnoreCase("next")) {
                break;
            }

            print("Enter a Model for your vehicle: ");
            String model = scanner.nextLine();

            print("Year of your vehicle: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            print("Plate: ");
            String plate = scanner.nextLine();

            print("Actual Speed(Km/h): ");
            float actualSpeed = scanner.nextFloat();
            scanner.nextLine();

            cars.add(new Car(brand, model, year, plate, actualSpeed));
        }


        while (true) {
            println("\nOptions:");
            println("1) Accelerate  2) Brake  3) Show Vehicle  4) Show All Vehicles  5) Exit");
            print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                println("Invalid input! Please enter a number between 1 and 5.");
                scanner.next();
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine();
            if (option < 1 || option > 5) {
                println("Invalid option! Please enter a valid option (1-5).");
                continue;
            }

            if (option == 5) {
                break;
            }

            if (option == 4) {
                for (Car car : cars) {
                    car.displayInfo();
                }
                continue;
            }

            print("Enter Plate: ");
            String plate = scanner.nextLine();

            Car selectedCar = null;

            for (Car car : cars) {
                if (car.getPlate().equalsIgnoreCase(plate)) { 
                    selectedCar = car;
                    break;
                }
            }

            if (selectedCar == null) {
                println("Vehicle not found.");
                continue;
            }

            switch (option) {
                case 1:
                    print("Enter Accelerate amount: ");
                    float accelerateAmount = scanner.nextFloat();
                    scanner.nextLine();
                    selectedCar.accelerate(accelerateAmount);
                    break;

                case 2:
                    print("Enter Brake amount: ");
                    float brakeAmount = scanner.nextFloat();
                    scanner.nextLine();
                    selectedCar.brake(brakeAmount);
                    break;

                case 3:
                    selectedCar.displayInfo();
                    break;

                default:
                    println("Invalid option.");
            }
        }

        scanner.close();
    }
}


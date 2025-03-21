import java.util.Scanner;

public class Main {
    public static void print(String a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        print("--------------------------");
        print("Welcome to our calculator");
        print("--------------------------");

        Scanner scanner = new Scanner(System.in);
        int next = 0;

        while (next == 0) {
            print("Choose your first number ");
            float n1 = scanner.nextFloat();

            print("Choose your second number ");
            float n2 = scanner.nextFloat();

            print("Choose your operation ");
            print("[1] Add ");
            print("[2] Subtract ");
            print("[3] Multiply ");
            print("[4] Divide ");
            int var = scanner.nextInt();
            if (var == 1) {
                print("The result is : " + calculator.add(n1, n2));
            } else if (var == 2) {
                print("The result is : " + calculator.subtract(n1, n2));
            } else if (var == 3) {
                print("The result is : " + calculator.multiply(n1, n2));
            } else if (var == 4) {
                print("The result is : " + calculator.divide(n1, n2));

            }
            scanner.nextLine();
            print("You want to continue ? [Y/N]");
            String ope = scanner.nextLine();

            if (ope.equals("Y")){
                print("--------------------------");
            }else if (ope.equals("N")){
                print("Operation Finished");
                next = 1;
            }

        }
    }
}

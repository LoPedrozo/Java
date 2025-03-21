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
        int continuar = 0;

        while (continuar == 0) {
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
            print("You want to continue ? [Yes/No]");
            String ope = scanner.nextLine();

            if (ope.equals("Yes")){
                print("--------------------------");
            }else if (ope.equals("No")){
                print("Operation Finished");
                continuar = 1;
            }

        }
    }
}
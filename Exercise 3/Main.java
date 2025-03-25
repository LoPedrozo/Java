import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void print(String p){

        System.out.print(p);
    }
    public static void println(String p){

        System.out.println(p);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            print("Enter account number (or 'next' to show the options): ");
            String accountNumber = scanner.nextLine();
            if (accountNumber.equalsIgnoreCase("next")) {
                break;
            }

            print("Enter account holder name: ");
            String accountHolder = scanner.nextLine();

            print("Enter initial balance: ");
            float balance = scanner.nextFloat();
            scanner.nextLine();

            accounts.add(new BankAccount(accountNumber, accountHolder, balance));
        }

        while (true) {
            println("" + "\nOptions: 1) Deposit  2) Withdraw  3) Show Account (Your Account)  4) Show All Accounts  5) Exit");
            print("Choose an option: ");
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
                for (BankAccount account : accounts) {
                    account.displayInfo();
                }
                continue;
            }

            print("Enter account number: ");
            String accountNumber = scanner.nextLine();
            BankAccount selectedAccount = null;


            for (BankAccount account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    selectedAccount = account;
                    break;
                }
            }

            if (selectedAccount == null) {
                println("Account not found.");
                continue;
            }

            switch (option) {
                case 1:
                    print("Enter deposit amount: ");
                    float depositAmount = scanner.nextFloat();
                    scanner.nextLine();
                    selectedAccount.deposit(depositAmount);
                    break;
                case 2:
                    print("Enter withdrawal amount: ");
                    float withdrawAmount = scanner.nextFloat();
                    scanner.nextLine();
                    selectedAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    selectedAccount.displayInfo();
                    break;
                default:
                    println("Invalid option.");
            }
        }

        scanner.close();
    }
}





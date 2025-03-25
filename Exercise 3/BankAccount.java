public class BankAccount {
    public static void println(String p){

        System.out.println(p);
    }
    private String accountNumber;
    private String accountHolder;
    private float balance;

    public BankAccount(String accountNumber, String accountHolder, float initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            println("Deposit of $" + amount + " completed successfully.");
        } else {
            println("Invalid deposit amount.");
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            println("Withdrawal of $" + amount + " completed successfully.");
        } else {
            println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public float getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void displayInfo() {
        println("Account Number: " + accountNumber);
        println("Account Holder: " + accountHolder);
        println("Balance: $" + balance);
        println("----------------------");
    }
}


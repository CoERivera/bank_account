import java.util.Random;
import java.lang.Math;
import java.text.NumberFormat;

class BankAccount {
    // CLASS ATTRIBUTES
    private double checkingBalance;
    private double savingsBalance;
    private int accountNumber;

    // STATIC CLASS VARIABLES
    private static int numberofAccounts = 0;
    private static double totalMoney = 0.0;

    // CONSTRUCTORS
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accountNumber = createAccountNumber();
        numberofAccounts++;
        totalMoney = totalMoney + checkingBalance + savingsBalance;
    }

    // GETTERS ONLY
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public int getNumberOfAccounts() {
        return numberofAccounts;
    }

    public void showTotalMoney() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total deposited in all accounts: " + formatter.format(totalMoney) + "\n");
    }

    // CREATE AN ACCOUNT NUMBER
    public int createAccountNumber() {
        int numbers = 0;
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            numbers += (random.nextInt(10) * Math.pow(10, i));
        }
        return numbers;

    }

    // DEPOSIT AND WITHDRAWAL METHODS
    public void depositToChecking(double amount) {
        checkingBalance += amount;
        totalMoney += amount;
    }

    public void depositToSavings(double amount) {
        savingsBalance += amount;
        totalMoney += amount;
    }

    public void withdrawFromChecking(double amount) {
        if (checkingBalance >= amount) {
            checkingBalance -= amount;
            totalMoney -= amount;
        }
    }

    public void withdrawFromSavings(double amount) {
        if (savingsBalance >= amount) {
            savingsBalance -= amount;
            totalMoney -= amount;
        }
    }

    // OBTAIN TOTAL BALANCE FROM ONE ACCOUNT NUMBER
    public double getTotalBalance() {
        return checkingBalance + savingsBalance;
    }

    // PRINT ACCOUNT INFO
    public void showAccountInfo() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance in checkings account: " + formatter.format(checkingBalance));
        System.out.println("Balance in savings account: " + formatter.format(savingsBalance));
        System.out.println("Total deposited in the account: " + formatter.format(getTotalBalance()));
        System.out.print("\n");
    }

}
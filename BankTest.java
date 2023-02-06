class BankTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(100, 200);
        
        account1.showAccountInfo();    
        account1.showTotalMoney();
        System.out.println("Number of accounts created so far: " + account1.getNumberOfAccounts() + ".\n");

        BankAccount account2 = new BankAccount(1000, 4000);
        
        account2.showAccountInfo();
        account2.showTotalMoney();    
        System.out.println("Number of accounts created so far: " + account2.getNumberOfAccounts() + ".\n");

    }    
}

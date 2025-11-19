import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\t\tDeposit successful. Updated balance: Rs." + balance);
	    System.out.println("\t\t\t**********");
        } else {
            System.out.println("\t\tInvalid amount. Deposit failed.");
	    System.out.println("\t\t\t**********");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\t\tWithdrawal successful. Remaining balance: Rs." + balance);
	    System.out.println("\t\t\t**********");
        } else {
            System.out.println("\t\tInvalid amount or insufficient funds. Withdrawal failed.");
            System.out.println("\t\t\t**********");
        }
    }
}

class ATM_Interface {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM_Interface(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
	System.out.println("\n\n\n\t\t\t*** Welcome To BOC ATM ***");
        System.out.println("\n\t\tATM Services");
        System.out.println("\t\t\t1.Check Balance");
        System.out.println("\t\t\t2.Withdraw Money");
        System.out.println("\t\t\t3.Deposit Money");
        System.out.println("\t\t\t4.Exit\n");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("\t\tInvalid option. Please try again.");
		System.out.println("\t\t\t**********");
        }
    }

    private void checkBalance() {
        System.out.println("\t\tYour balance is: Rs." + bankAccount.getBalance());
	System.out.println("\t\t\t**********");
    }

    private void withdrawMoney() {
        System.out.print("\t\tEnter the amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    private void depositMoney() {
        System.out.print("\t\tEnter the amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void exit() {
        System.out.println("\t\tThank you for using the ATM. Goodbye!");
	System.out.println("\t\t\t\t***************");
        System.exit(0);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM_Interface atm = new ATM_Interface(userAccount);

        while (true) {
            atm.displayMenu();

            System.out.print("\t\tEnter your choice (1-4): ");
            int choice = atm.scanner.nextInt();

            atm.processOption(choice);
        }
    }
}

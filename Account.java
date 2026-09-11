import java.util.Scanner;

interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void balanceEnquiry();
}

class Bank implements BankAccount {
    String name;
    int accNo;
    double balance;

    Bank(String name, int accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount");
            return;
        }
        balance += amount;
        System.out.println("Amount Deposited Successfully");
        System.out.println("Available Balance: Rs. " + balance);
    }

    public void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new Exception("Insufficient Balance");
            }
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully");
            System.out.println("Available Balance: Rs. " + balance);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Transaction Failed");
            System.out.println("Available Balance: Rs. " + balance);
        }
    }

    public void balanceEnquiry() {
        System.out.println("Available Balance: Rs. " + balance);
    }
}

public class Account{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Bank b = new Bank(name, accNo, balance);

        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Balance Enquiry");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Deposit Amount: ");
                double dep = sc.nextDouble();
                b.deposit(dep);
                break;

            case 2:
                System.out.print("Enter Withdraw Amount: ");
                double with = sc.nextDouble();
                b.withdraw(with);
                break;

            case 3:
                b.balanceEnquiry();
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
import java.util.*;
import java.util.Scanner;

interface ATM_helper {
    float withdraw();

    float deposit();

    float checkbalance();
}

class ATM {
    float withdraw(float balance_amount, float amount) {
        balance_amount -= amount;
        return (balance_amount);
    }

    float deposit(float balance_amount, float amount) {
        balance_amount += amount;
        return (balance_amount);
    }

    float checkbalance(float balance_amount) {
        return (balance_amount);
    }
}

class Bank_account extends ATM {
    Scanner sc = new Scanner(System.in);
    int acc_no;
    int age;
    String name;
    int id;
    float balance_amount;
    float amount;

    void enter() {
        System.out.println("Enter the name of the account holder");
        name = sc.nextLine();
        System.out.println("Enter the account number of the account holder");
        acc_no = sc.nextInt();
        System.out.println("Enter the age of the account holder");
        age = sc.nextInt();
        System.out.println("Enter the id of the account holder");
        id = sc.nextInt();
        System.out.println("Enter the balance amount of the account holder");
        balance_amount = sc.nextFloat();
    }

    void mainwithdraw(float amount) {
        if (amount <= balance_amount) {
            balance_amount = withdraw(balance_amount, amount);
        } else {
            System.out.println("Amount entered cannot be withrawn due to insufficient balance" + balance_amount);
        }
    }

    void maindeposit(float amount) {
        balance_amount = deposit(balance_amount, amount);
    }

    void maincheckbalance() {
        balance_amount = checkbalance(balance_amount);
        System.out.println(balance_amount);
    }
}

class bank_interface_code {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Bank_account obj = new Bank_account();
        obj.enter();
        int choice;
        char ch = 'y';
        float amount;
        while (ch == 'y') {
            System.out.println("1-Withdraw");
            System.out.println("2-Deposit");
            System.out.println("3-Check Balance");
            System.out.println("4-Exit");
            System.out.println("enter the choice to be executed");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("enter the amount to be withdrawn");
                amount = sc.nextFloat();
                obj.mainwithdraw(amount);
                System.out.println("Now the balance is");
                obj.maincheckbalance();
            } else if (choice == 2) {
                System.out.println("enter the amount to be deposited");
                amount = sc.nextFloat();
                obj.maindeposit(amount);
                System.out.println("Now the balance is");
                obj.maincheckbalance();

            } else if (choice == 3) {
                System.out.println("Check the balance in your account");
                obj.maincheckbalance();
            } else {
                System.exit(0);
            }
            System.out.println("do you want to continue??");
            ch = sc.next().charAt(0);
        }
    }
}
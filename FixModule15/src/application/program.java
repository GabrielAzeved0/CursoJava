package application;

import model.entities.Account;
import model.execeptions.ProgramExeceptions;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.print("New balance: " + account.getBalance());


        }
        catch (ProgramExeceptions e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        sc.close();
    }
}

package com.juaracoding;

public class BankAccount {
    int acc_no;
    String name;
    double amount;
    double amounts;

    public String setAccount(String n) {
//        acc_no = a;
        name = n;
//        amount = amt;
        System.out.println(name);
        return name;


    }

    public double deposit(double amt,double amount) {
        amounts = amount + amt;
        System.out.println(amounts + " deposited");
        return amounts;
    }


    public double withdraw(double amt,double amount) {
        if (amount < amt) {
            System.out.println("Insufficient Balance");
        } else {
            amount = amount - amt;
            System.out.println(amt + " withdrawn");
        }
        return amount;
    }

    public double checkBalance( double amount) {
        System.out.println("Balance is: " + amount);
        return amount;
    }

    public int display(int acc_no) {
        BankAccount bankAccount = new BankAccount();
        String cobaNama = bankAccount.setAccount("fery");
        double cobaamount = bankAccount.deposit(100,1000);
        System.out.println(acc_no + " " + cobaNama + " " + cobaamount);
        return acc_no;
    }
}

package com.driver;

import java.util.Arrays;

public class BankAccount {

    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.balance=balance;
        this.name=name;
        this.minBalance=minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum>(Math.pow(10,digits)-1))
            throw new Exception("Account Number can not be generated");
        int arr[] = new int[digits];
        for (int i = 0; i < sum; i++)
        {
            arr[(int)(Math.random() * digits)]++;
        }
        String accNo= Arrays.toString(arr);
        return accNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance)
            throw new Exception("Insufficient Balance");
        balance-=amount;
    }

}
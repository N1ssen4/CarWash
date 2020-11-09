package com.kea;

public class WashCard {
    private double balance = 200;
    public WashCard(){
    }
    public double getBalance()
    {
        return balance;
    }
    public void addToBalance(double amount)
    {
        balance += amount;
    }
    public void deductFromBalance(double amount)
    {
        balance -= amount;
    }

}
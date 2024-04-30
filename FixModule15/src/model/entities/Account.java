package model.entities;

import model.execeptions.ProgramExeceptions;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;


    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws ProgramExeceptions {
        if (amount > withdrawLimit){
            throw new ProgramExeceptions("The amount exceeds withdraw limit");
        }
        else if (balance < amount){
            throw new ProgramExeceptions("Not enough balance");
        }
        balance -= amount;
    }


}

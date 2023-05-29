package com.devbank.users;

public class Account {
    private static final int MAX_LENGTH = 14;
    private String ag;
    private String cc;
    private String name;
    private double balance;
    private Log logger;


    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
        //System.out.println(this.name);
    }

    public void deposit(double value){
        balance += value;
        logger.out(("DEPOSITO - " + value));
        logger.out(("DEPOSITO - Valor depositado com sucesso"));
        logger.out("DEPOSITO - Saldo atual: " + balance + "\n");
    }

    public boolean withDraw(double value) {
        if (balance < value) {
            logger.out("SAQUE - Saldo insuficiente");
            return false;
        } else {
            balance -= value;
            logger.out("SAQUE - " + value);
            logger.out(("SAQUE - Valor sacado com sucesso"));
            logger.out("SAQUE - Saldo atual: " + balance + "\n");
            return true;
        }
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        String result = "\nConta: " + "\n" + this.name + "\n" + this.ag + "-" + this.cc  + "\nSaldo: " + balance;
        return result;
    }
}

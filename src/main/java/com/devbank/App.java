package com.devbank;

import com.devbank.users.Account;
import com.devbank.users.Bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank nubank = new Bank("001");

        int choice;

        do {
            // C = criar conta
            // E = Sair
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 = Criar conta");
            System.out.println("0 = Sair");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nDigite o seu nome");
                    String name = scanner.next();
                    Account account = nubank.generateAccount(name);
                    nubank.insertAccount(account);

                    operateAccount(account);
                }
                case 0 -> System.out.println("\nEncerrando o programa...");
                default -> System.out.println("\nOpção inválida!");
            }
        } while (choice != 0);

        List<Account> accountList = nubank.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }

        nubank.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // D = Deposito
            // S = Saque
            // E = Sair
            System.out.println("\nO que deseja fazer?");
            System.out.println("1 = Deposito");
            System.out.println("2 = Saque");
            System.out.println("0 = Sair");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nQual valor deseja depositar?");
                    double value = scanner.nextDouble();
                    account.deposit(value);
                }
                case 2 -> {
                    System.out.println("\nQual valor deseja sacar?");
                    double value = scanner.nextDouble();
                    account.withDraw(value);
                }
                case 0 -> System.out.println("\nEncerrando o programa...");
                default -> System.out.println("\nOpção inválida!");
            }
        } while (choice != 0);
    }
}
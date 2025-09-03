package Account;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) 
    {
        Account account1 = new Account("Jane", 50.00, 88091, 10000);
        Account account2 = new Account("John", -7.53, 97600, 6000);

        System.out.printf("%s Saldo: $%.2f Número da conta: %d Limite: %d%n",
        account1.getName(), account1.getBalance(), account1.getNum(), account1.getLimit());
        System.out.printf("%s Saldo: $%.2f Número da conta: %d Limite: %d%n",
        account2.getName(), account2.getBalance(), account2.getNum(), account2.getLimit());


        Scanner input = new Scanner(System.in);

        System.out.print("Quantidade a ser depositada na conta 1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nAdicionando %.2f na conta 1%n%n", depositAmount);
        account1.deposit(depositAmount);

        System.out.printf("%s Saldo: $%.2f %n", account1.getName(), account1.getBalance());
        System.out.printf("%s Saldo: $%.2f %n%n", account2.getName(), account2.getBalance());

        System.out.print("Quantidade a ser depositada na conta 2: ");
        depositAmount = input.nextDouble();
        System.out.printf("%nAdicionando %.2f na conta 2%n%n", depositAmount);
        account2.deposit(depositAmount);

        System.out.printf("%s Saldo: $%.2f %n", account1.getName(), account1.getBalance());
        System.out.printf("%s Saldo: $%.2f %n%n", account2.getName(), account2.getBalance());

    }
}
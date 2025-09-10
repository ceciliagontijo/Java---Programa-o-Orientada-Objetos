package Account;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) 
    {
        Account account1 = new Account("Jane", 88091, 1000);
        Account account2 = new Account("John", 97600, 3000);

        System.out.printf("%s - Saldo: $%.2f - Número da conta: %d - Limite: %.2f%n",
        account1.getName(), account1.getBalance(), account1.getNum(), account1.getLimit());
        System.out.printf("%s - Saldo: $%.2f - Número da conta: %d - Limite: %.2f%n",
        account2.getName(), account2.getBalance(), account2.getNum(), account2.getLimit());

        Scanner input = new Scanner(System.in);

        System.out.printf("Dia = %n");
        int d = input.nextInt();
        System.out.printf("Mês = %n");
        int m = input.nextInt();
        System.out.printf("Ano = %n");
        int y = input.nextInt();

        try
        {
            Date data1 = new Date(d, m, y);
            System.out.printf("Data = %d/%d/%d%n%n", data1.getDay(), data1.getMonth(), data1.getYear());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Erro ao criar data: " + e.getMessage());
        }

        System.out.print("Quantidade a ser depositada na conta 1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nAdicionando %.2f na conta 1%n%n", depositAmount);
        account1.deposit(depositAmount);

        System.out.printf("%s - Saldo: $%.2f %n", account1.getName(), account1.getBalance());
        System.out.printf("%s - Saldo: $%.2f %n%n", account2.getName(), account2.getBalance());

        System.out.print("Quantidade a ser depositada na conta 2: ");
        depositAmount = input.nextDouble();
        System.out.printf("%nAdicionando %.2f na conta 2%n%n", depositAmount);
        account2.deposit(depositAmount);

        System.out.printf("%s - Saldo: $%.2f %n", account1.getName(), account1.getBalance());
        System.out.printf("%s - Saldo: $%.2f %n%n", account2.getName(), account2.getBalance());

        System.out.print("Quantidade que deseja sacar na conta 1: ");
        double saqueAmount = input.nextDouble();
        account1.withdraw(saqueAmount);

        System.out.printf("%s - Novo saldo: $%.2f - Limite: $%.2f%n", account1.getName(), account1.getBalance(), account1.getLimit());

        System.out.print("Quantidade que deseja sacar na conta 2: ");
        saqueAmount = input.nextDouble();
        account2.withdraw(saqueAmount);

        System.out.printf("%s - Novo saldo: $%.2f - Limite: $%.2f%n%n", account2.getName(), account2.getBalance(), account2.getLimit());

        System.out.print("Digite a senha atual: ");
        input.nextLine();
        String oldPass = input.nextLine();
        System.out.print("Digite a nova senha: ");
        String newPass = input.nextLine();
        account1.mudaSenha(oldPass, newPass);

        input.close();
    }
}
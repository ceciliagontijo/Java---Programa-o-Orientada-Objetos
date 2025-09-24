package Account;

import java.util.Scanner;
import java.util.ArrayList;

public class AccountTest 
{
    public static void main(String[] args) 
    {

        Scanner input = new Scanner(System.in);
        ArrayList<Account> contas_corrente = new ArrayList<>();
        ArrayList<Account> contas_especial = new ArrayList<>();

        System.out.printf("Dia = %n");
        int d = input.nextInt();
        System.out.printf("Mês = %n");
        int m = input.nextInt();
        System.out.printf("Ano = %n");
        int y = input.nextInt();

        try
        {
            Date data1 = new Date(d, m, y);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Erro ao criar data: " + e.getMessage());
        }
    
        int user;
        System.out.println("\n--- MENU DE ENTRADA ---");
        System.out.println("1 - Gerente");
        System.out.println("2 - Cliente");
        System.out.println("3 - Sair");
        user = input.nextInt();
    do 
    {

        if (user == 1)
        {
            int ger;
            System.out.println("1 - Criar nova conta (corrente, poupança ou especial)");
            System.out.println("2 - Visualizar informações de conta");
            ger = input.nextInt();
            switch(ger)
            {
                case 1: 
                    int conta;
                    System.out.println("Qual tipo de conta deseja criar?");
                    System.out.println("1 - Corrente");
                    System.out.println("2 - Especial");
                    conta = input.nextInt();
                    if (conta == 1)
                    {
                        String nome;
                        int id;
                        System.out.print("Nome da conta: ");
                        input.nextLine();
                        nome = input.nextLine(); 
                        System.out.print("Número da conta: ");
                        id = input.nextInt();
                        Account novaConta = new Account(nome, id);
                        contas_corrente.add(novaConta); // Adiciona a conta à lista
                    }
                    else 
                    {
                        String nome;
                        int id;
                        int limit;
                        System.out.print("Nome da conta: ");
                        input.nextLine();
                        nome = input.nextLine(); 
                        System.out.print("Número da conta: ");
                        id = input.nextInt();
                        System.out.print("Limite da conta: ");
                        limit = input.nextInt();
                        Account novaConta = new Account(nome, id, limit);
                        contas_especial.add(novaConta);
                    }
                    break;
                
                case 2:
                    System.out.print("Digite o número da conta que deseja acessar: ");
                    int id = input.nextInt();

                    boolean encontrada = false;

                    for (int i=0; i < contas_corrente.size(); i++)
                    {
                        Account c = contas_corrente.get(i); // pega o elemento na posicao i
                        if (c.getNum() == id)
                        {
                            System.out.println(c); // toString;
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada)
                    {
                        for (int i=0; i < contas_especial.size(); i++)
                        {   
                            Account c = contas_especial.get(i);
                        
                            if (c.getNum() == id)
                            {
                                System.out.println(c);
                                encontrada = true;
                                break;
                            }
                        }
                    }

                    if (!encontrada)
                    {
                        System.out.println("Conta não existe!");
                    }
                    break;
            }
        }

        if (user == 2)
        {

            System.out.println("Número da conta que deseja acessar: ");
            int id = input.nextInt();

            boolean encontrada = false;

                for (int i=0; i < contas_corrente.size(); i++)
                    {
                        Account c = contas_corrente.get(i); // pega o elemento na posicao i
                        if (c.getNum() == id)
                        {
                            System.out.println("Digite a senha: "); 
                            input.nextLine();
                            String Pass = input.nextLine();
                            int resul = c.verificaSenha(Pass);
                            if (resul == 1)
                            {
                                System.out.println("Conta acessada! O que deseja fazer?");
                                int option=0;
                               
                                do 
                                    {
                                        System.out.println("1 - Depositar");
                                        System.out.println("2 - Sacar");
                                        System.out.println("3 - Ver saldo");
                                        System.out.println("4 - Trocar senha");
                                        System.out.println("5 - Verifica data que a conta foi aberta");
                                        System.out.print("Escolha uma opção: ");
                                        option = input.nextInt();
                                    } while(option < 1 || option >5);
                
                                switch(option)
                                    {
                                        case 1:
                                            System.out.print("Quantidade a ser depositada na conta: ");
                                            double depositAmount = input.nextDouble();
                                            c.deposit(depositAmount);
                                            break;
                                                
                                        case 2:
                                            System.out.print("Quantidade que deseja sacar na conta: ");
                                            double saqueAmount = input.nextDouble();
                                            c.withdraw(saqueAmount);
                                            break;

                                        case 3:
                                            System.out.printf("%s - Saldo: $%.2f - Limite: $%.2f%n", c.getName(), c.getBalance(), c.getLimit());
                                            break;

                                        case 4:
                                            System.out.print("Digite a senha atual: ");
                                            input.nextLine();
                                            String oldPass = input.nextLine();
                                            System.out.print("Digite a nova senha: ");
                                            String newPass = input.nextLine();
                                            c.mudaSenha(oldPass, newPass);
                                            break;
                                                
                                            case 5:
                                                try
                                                    {
                                                        Date data1 = new Date(d, m, y);
                                                        System.out.printf("Data = %d/%d/%d%n%n", data1.getDay(), data1.getMonth(), data1.getYear());
                                                    }
                                                catch (IllegalArgumentException e)
                                                    {
                                                        System.out.println("Erro ao criar data: " + e.getMessage());
                                                    }
                                    }

                            }
                            else 
                            {
                                System.out.println("Senha incorreta! Não foi possível acessar a conta.");
                            }
                            encontrada = true;
                            break;
                        }
                                }

                    if (!encontrada)
                    {
                        System.out.println("Conta não existe!");
                    }         
        }

        System.out.println("\n--- MENU DE ENTRADA ---");
        System.out.println("1 - Gerente");
        System.out.println("2 - Cliente");
        System.out.println("3 - Sair");
        user = input.nextInt();

    } while(user != 3);
        input.close();
    }
}
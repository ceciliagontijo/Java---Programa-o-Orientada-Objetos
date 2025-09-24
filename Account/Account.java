package Account;

public class Account
{
    private String name;
    private double balance;
    private int num;
    private double limit;
    private String password;
    private Date openingDate;
    
    public Account(String name, int num) //construtor sem parametros
    {
        this.name = "";
        this.balance = 0.0;
        this.num = 0;
        this.limit = 0;
        this.password = "0000";
    }

    public Account() //construtor sem parametros
    {
        this.name = "";
        this.balance = 0.0;
        this.num = 0;
        this.limit = 0;
        this.password = "0000";
    }

    public Account(String name, int num, double limit) //construtor com parametros
    {
        this.name = name;
        this.num = num;
        this.limit = limit;
        this.balance = 0.0;
        this.password = "0000";
    }

    public void deposit(double depositAmount)
    {
        if(balance+depositAmount > limit)
        {
            System.out.printf("O valor adicionado ultrapassa o limite da conta!!%n");
        }
        else
        {
            balance = balance + depositAmount;
        }
    }

    public void withdraw(double saqueAmount)
    {
    
        if (balance - saqueAmount > 0)
            {
                balance = balance - saqueAmount;
            }
        else
            {
            if (limit > (saqueAmount - balance))
            {
                limit = limit - (saqueAmount - balance);
                balance = 0.0;
                System.out.printf("%nO valor excedido no seu saque está sendo retirado do seu limite.%n");
            }
            else
            {
                System.out.printf("%nNão é possível sacar esse valor pois ultrapassa seu limite!%n");
            }
            }
     }
    
    

    public void mudaSenha(String oldPass, String newPass)
    {
        if (oldPass.equals(password))
        {
            password = newPass;
            System.out.printf("Senha atualizada com sucesso! Nova senha = %s", password);
        }
        else
        {
            System.out.printf("%nSenha incorreta! Não foi possível alterá-la!!!%n");
        }
    }

    public double getBalance()
    {
        return balance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getNum()
    {
        return num;
    }

      public double getLimit()
    {
        return limit;
    }

    public Date getOpeningDate()
    {
        return openingDate;
    }
}
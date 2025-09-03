package Account;

public class Account
{
    private String name;
    private double balance;
    private int num;
    private int limit;

    public Account(String name, double balance, int num, int limit)
    {
        this.name = name;
        this.num = num;
        this.limit = limit;

        if (balance > 0.0)
            this.balance = balance;
    }

    public void deposit(double depositAmount)
    {
        if(balance+depositAmount > limit)
        {
            System.out.printf("O valor adicionado ultrapassa o limite da conta!!");
        }
        else
        {
            balance = balance + depositAmount;
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

      public int getLimit()
    {
        return limit;
    }
}
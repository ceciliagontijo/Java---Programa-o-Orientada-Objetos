package Account;

public class Date 
{
    private int month;
    private int day;
    private int year;

    public Date(int day, int month, int year)
    {
        if(month <= 12)
        {
            this.month = month;
        }
        else
        {
            System.out.printf("Não existe esse mês!%n");
        }
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            if (day <= 31)
            {
                this.day = day;
            }
            else
            {
                System.out.printf("Não existe esse dia!%n");
            }
        }
            else
            {
                if (day <= 30)
                {
                    this.day = day;
                }
                else 
                {
                    System.out.printf("Não existe esse dia!%n");
                }
            }
        this.year = year;
    }
}

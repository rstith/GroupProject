package accounts;

/**
 *
 * @author Nic
 */
public class Account 
{
    protected int accountNumber;
    protected int customerID;
    protected int day;
    protected int month;
    protected int year;
    protected double accountTotal;
    
    public Account(int accNum, int custID)
    {
        accountNumber = accNum;
        customerID = custID;
    }
    
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    public int getCustomerID()
    {
        return customerID;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getYear()
    {
        return year;
    }    
    
    public double getAccountTotal()
    {
        return accountTotal;
    }
    
    public void setDay(int d)
    {
        day = d;
    }
    
    public void setMonth(int m)
    {
        month = m;
    }
    
    public void setYear(int y)
    {
        year = y; 
    }
    
    public void credit(double amount)
    {
        accountTotal += amount;
    }
}

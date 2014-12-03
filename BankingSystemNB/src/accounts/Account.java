package accounts;

import database.SQLDriver;
import java.sql.ResultSet;

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
    protected int accountOpen = 1; //0 is a closed account, 1 is an open account
    protected SQLDriver db = new SQLDriver();
    protected String accountType;
    protected String databaseCallTableName;
    protected String databaseCallAccountNumber;
    
    public Account(int accNum, int custID, double accountTotal, String accountType)
    {
        accountNumber = accNum;
        customerID = custID;
        this.accountTotal = accountTotal;
        
        databaseCallTableName = accountType;
        databaseCallAccountNumber = Integer.toString(accNum);
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
    
    public Account search(int findID){
                String statement = "SELECT * FROM " + databaseCallTableName + " WHERE " + databaseCallAccountNumber + " = " + findID;

                try{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next()){
                            this.accountNumber = res.getInt("accountID");
                            this.accountOpen = res.getInt("Active");
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return this;
        } 
}

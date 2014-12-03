package accounts;

import java.sql.ResultSet;

/**
 *
 * @author Nic
 */
public class Savings extends Account
{
    protected double interestRate = 0.0;
    protected double interestAccrued = 0.0;
    protected int savingsType;//0 for CD, 1 for simpleSavings
    
    public Savings(int accNum, int custID, double accTot, String accType)
    {
        super(accNum, custID, accTot, accType);
    }
    
    public void setInterestRate(double rate)
    {
        interestRate = rate;
    }
    
    public double getInterestRate(double interestRate)
    {
        return interestRate;
    }
    
    public void withdraw(double amount)
    {
        accountTotal -= amount;
    }
    
    public void calculateInterestRate()
    {
        interestAccrued = accountTotal * interestRate;
    }
    
        @Override
    public Account search(int findID){
                String statement = "SELECT * FROM " + databaseCallTableName + " WHERE " + databaseCallAccountNumber + " = " + findID;

                try{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next()){
                            this.accountNumber = res.getInt("accountID");
                            this.accountTotal = res.getDouble("balance");
                            this.accountOpen = res.getInt("Active");
                            this.interestRate = res.getDouble("Interest");
                            
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return this;
        } 
}
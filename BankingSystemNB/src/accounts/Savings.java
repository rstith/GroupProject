package accounts;

/**
 *
 * @author Nic
 */
public class Savings extends Account
{
    protected double interestRate = 0.0;
    protected double interestAccrued = 0.0;
    protected int savingsType;//0 for CD, 1 for simpleSavings
    
    public Savings(int accNum, int custID)
    {
        super(accNum, custID);
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
}

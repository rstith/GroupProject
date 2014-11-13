package accounts;

/**
 *
 * @author Nic
 */
public class SimpleSavings extends Savings
{
    public SimpleSavings(int accNum, int custID)
    {
        super(accNum, custID);
    }
    
    public void deposit(double amount)
    {
        accountTotal += amount;
    }
    
    public double getInterestRate()
    {
        return interestRate;
    }
}

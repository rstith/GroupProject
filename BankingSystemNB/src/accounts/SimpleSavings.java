package accounts;

/**
 *
 * @author Nic
 */
public class SimpleSavings extends Savings
{
    public SimpleSavings(int accNum, int custID, double accTot, String accType)
    {
        super(accNum, custID, accTot, accType);
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

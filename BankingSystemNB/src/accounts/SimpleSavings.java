package accounts;

/**
 *
 * @author Nic
 */
public class SimpleSavings extends Savings
{
    public SimpleSavings(int accNum, int custID, double accTot, String accType,  int day, int month, int year)
    {
        super(accNum, custID, accTot, accType, day, month, year);
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

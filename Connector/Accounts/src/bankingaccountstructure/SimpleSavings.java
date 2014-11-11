/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingaccountstructure;

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
    
    public void calculateInterest()
    {
        accountTotal += accountTotal * interestRate;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingaccountstructure;

/**
 *
 * @author Nic
 */
public class Savings extends Account
{
    protected double interestRate;
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
    
    public void deposit(double amount)
    {
        accountTotal += amount;
    }
    
    public void withdraw(double amount)
    {
        accountTotal -= amount;
    }
}

package accounts;

/**
 *
 * @author Nic
 */
public class Checking extends Account
{
    protected double stopPaymentFee = 15.00;
    protected double overdraftFee = 20.00;
    protected Savings linkedAccount;
    protected int overdraftProtection;//0 for none, 1 for yes
    
    protected double checkAmt;
    protected int checkNO;
    protected int checkDay, checkMonth, checkYear;
    
    public Checking(int accNum, int custID, double accTot)
    {
        super(accNum, custID);
        accountTotal = accTot;
    }
    
    public void debit(double amount)
    {
        accountTotal -= amount;
    }
    
    public Savings getLinkedAccount()
    {
        return linkedAccount;
    }
    
    public void overdraftCharge()
    {
        accountTotal -= overdraftFee;
    }
    
    public void linkAccount(Savings linkedSavings)
    {
        linkedAccount = linkedSavings;
    }
    
    public double transferFunds(double transferAmount, Account transferTo)
    {
        /*
         * This will accept the amount to transfer and the account to transfer to.
         * First, check if there is enough funds in the checking account
         * If there is enough funds, debit the checking acount and credit the account
         * being transfered to. Return the accoutn being tranfered to so the GUI
         * can update the database entry for that account.
         */
        if(transferAmount > accountTotal)
        {
            System.out.println("Not Enough Funds");
        }
        else
        {
            accountTotal -= transferAmount;
            transferTo.credit(transferAmount);
            System.out.println("Transfered: $" + transferAmount);
            System.out.println("Current Checking Total: $" + accountTotal);
            System.out.println(transferTo.getAccountNumber() + " - Current Total : $" + transferTo.getAccountTotal());
        }
        
        return transferTo.getAccountTotal();
    }
    
    /*MIGHT NOT HAVE TO IMPLEMENT
    public void createCheck(int checkNumber, double checkAmount, int checkD, int checkM, int checkY)
    {
        checkNO = checkNumber;
        checkAmt = checkAmount;
        checkDay = checkD;
        checkM = checkM;
        checkY = checkY;
    }
    */
}

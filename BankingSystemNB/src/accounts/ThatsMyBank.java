package accounts;

/**
 *
 * @author Nic
 */
public class ThatsMyBank extends Checking
{
    private double monthlyPaymentsFee = 0.75;
    private double transferFee = 0.50;
    
    public ThatsMyBank(int accNum, int custID, double accTot, String accType, String checkingType)
    {
        super(accNum, custID, accTot, accType, checkingType);
    }
    
    @Override
    public double transferFunds(double transferAmount, Account transferTo)
    {
        /*
         * This will accept the amount to transfer and the account to transfer to.
         * First, check if there is enough funds in the checking account
         * If there is enough funds, debit the checking acount and credit the account
         * being transfered to. Return the accoutn being tranfered to so the GUI
         * can update the database entry for that account.
         * 
         * THIS TYPE OF CHECKING COST MONEY TO TRANSFER
         */
        if(transferAmount > accountTotal)
        {
            System.out.println("Not Enough Funds");
        }
        else
        {
            accountTotal -= transferAmount;
            accountTotal -= transferFee;
            transferTo.credit(transferAmount);
            System.out.println("Transfered: $" + transferAmount);
            System.out.println("Current Total: $" + accountTotal);
            System.out.println(transferTo.getAccountNumber() + " - Current Total : $" + transferTo.getAccountTotal());       
        }
        return transferTo.getAccountTotal();
    }
}

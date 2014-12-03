package accounts;

import java.sql.ResultSet;

/**
 *
 * @author Nic
 */
public class Checking extends Account
{
    protected double stopPaymentFee = 15.00;
    protected double overdraftFee = 20.00;
    protected String linkedAccount;
    protected int overdraftProtection;//0 for none, 1 for yes
    
    protected double checkAmt;
    protected int checkNO;
    protected int checkDay, checkMonth, checkYear;
    
    public Checking(int accNum, int custID, double accTot, String accType)
    {
        super(accNum, custID, accTot, accType);
    }
    
    public void debit(double amount)
    {
        if(amount <= accountTotal)
        {
            accountTotal -= amount;
        }
        else
        {
            System.out.println("NOT ENOUGH FUNDS"); 
        }
    }
    
    public String getLinkedAccount()
    {
        return linkedAccount;
    }
    
    public void overdraftCharge()
    {
        accountTotal -= overdraftFee;
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
    
    @Override
    public Account search(int findID){
                String statement = "SELECT * FROM " + databaseCallTableName + " WHERE " + databaseCallAccountNumber + " = " + findID;

                try{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next()){
                            this.accountNumber = res.getInt("accountID");
                            this.accountTotal = res.getDouble("value");
                            this.linkedAccount = res.getString("SavingsAcc");
                            this.accountOpen = res.getInt("Active");
                            
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return this;
        } 
}


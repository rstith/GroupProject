package accounts;

/**
 *
 * @author Nic
 */
public class MortgageLoans extends Loans
{    
    int loanLength; //MUST BE 15 or 20. LENGHT IN YEARS
    public MortgageLoans(int accNum, int custID, double accTot, String accType, double mpay, int length, double interestRate)
    {
        super(accNum, custID, accTot, accType, mpay, interestRate);
        loanLength = length;
    }   
    
    public void setLoanLength(int length)
    {
        if(length == 15 || length == 20)
        {
            loanLength = length;
        }
        else
        {
            System.out.println("Loan Length must be 10 or 15 years");
        }
    }
    
    public int getLoanLength()
    {
        return loanLength;
    }
}

package accounts;

/**
 *
 * @author Nic
 */
public class ShortTermLoans extends Loans
{
    int loanLength; //MUST BE 10 OR UNDER. LENGHT IN YEARS
    public ShortTermLoans(int accNum, int custID, double accTot, double mpay, int length)
    {
        super(accNum, custID, accTot, mpay);
        loanLength = length;
    }   
    
    public void setLength(int length)
    {
        if(length <= 10 && length > 0)
        {
            loanLength = length;
        }
        else
        {
            System.out.println("Length has to be between 0 and 10 years");
        }
    }
    
    public int getLength()
    {
        return loanLength;
    }
}

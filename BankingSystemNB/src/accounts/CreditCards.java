package accounts;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Nic
 */
public class CreditCards extends Loans
{
    private double cardLimit;
    private double financeCharge;
    private Date chargeDate;
    
    public CreditCards(int accNum, int custID, double accTot, double mpay, double lim)
    {
        super(accNum, custID, accTot, mpay);
        cardLimit = lim;
    }   
    
    public void setCardLimit(double lim)
    {
        cardLimit = lim;
    }
    
    public void setFinanceCharge(double charge)
    {
        financeCharge = charge;
    }
    
    public double getCardLimit()
    {
        return cardLimit;
    }
    
    public double getFinanceCharge()
    {
        return financeCharge;
    }
    
    public double chargeCard(double amount)
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        
        int currentDay = localCalendar.get(Calendar.DATE);
        int currentMonth = localCalendar.get(Calendar.MONTH);
        int currentYear = localCalendar.get(Calendar.YEAR);
        Date currentDate = new Date(currentYear - 1900, currentMonth, currentDay);//YEAR STARTS AT 1900
        
        chargeDate = currentDate;
        accountTotal += amount;
        MONTHLY_PAYMENT += amount;
        /*
         * If making a payment over the limit, cancel the payment
         */
        if(accountTotal >= cardLimit)
        {
            System.out.println("Amount over limit");
            accountTotal -= amount;
            MONTHLY_PAYMENT -= amount;
        }
        return accountTotal;
    }
}
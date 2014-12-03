package accounts;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Nic
 */
public class CD extends Savings
{
    private int CDlength;//CD LENGTH IN MONTHS
    private int rollOverDay, rollOverMonth, rollOverYear;
    private int active = 1; //0 is not active, 1 is active
    private int TIME_FRAME = 15;//Days before roll over date to withdraw
    private double penalty = 50.00;//Fee for withdrawing before end date
    
    public CD(int accNum, int custID, String accType, int length, int rday, int rmonth, int ryear, double amount, int day, int month, int year)
    {
        super(accNum, custID, amount, accType, day, month, year);
        CDlength = length;
        rollOverDay = rday;
        rollOverMonth = rmonth;
        rollOverYear = ryear;
    }
    
    public void setRollOverDate(int srday, int srmonth, int sryear)
    {
        rollOverDay = srday;
        rollOverMonth = srmonth;
        rollOverYear = sryear;
    }
    
    public Date getRollOverDate()
    {
        
        Date rollOverDate = new Date(rollOverYear, rollOverMonth, rollOverDay); //DATE OF ROLLOVER
        return rollOverDate;
    }
    
    public void setActive(int act)
    {
        active = act;
    }
    
    public int getActive()
    {
        if(active == 0)
        {
            System.out.println("CD is closed");
        }
        else
        {
            System.out.println("CD is open");
        }
        return active;
    }
    
    @Override
    public void withdraw(double amount)
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        
        int currentDay = localCalendar.get(Calendar.DATE);
        int currentMonth = localCalendar.get(Calendar.MONTH);
        int currentYear = localCalendar.get(Calendar.YEAR);
        
        //Create dates using inputed CD dates and the current date
        Date currentDate = new Date(currentYear - 1900, currentMonth, currentDay);//YEAR STARTS AT 1900
        Date rollOverDate1 = new Date(rollOverYear, rollOverMonth, rollOverDay); //DATE OF ROLLOVER
        Date rollOverDate2 = new Date(rollOverYear, rollOverMonth, rollOverDay - TIME_FRAME); //DATE OF ROLL OVER MINUS TIME PERIOD DAYS
        
        System.out.println(rollOverDate2.toString());
        System.out.println(rollOverDate1.toString());
        System.out.println(currentDate.toString());
        
        //Check if the current date is within the limit for withdrawing a CD
        if(currentDate.after(rollOverDate2) && currentDate.before(rollOverDate1)) 
        {
                System.out.println("Within Roll Over Date");
                if(amount < accountTotal)
                {
                    //The withdraw amount is acceptable but not the full CD amount
                    System.out.println("You Withdraw $" + amount);
                    accountTotal -= amount;
                    System.out.println("You have $" + accountTotal + " left in the CD");
                }
                else if( amount == accountTotal)
                {
                    //Withdrawing the entire CD
                    System.out.println("You Withdraw the entire CD of $" + accountTotal);
                    accountTotal = 0;
                    active = 0;
                    System.out.println("CD HAS BEEN CLOSED");
                }
                else
                {
                    //Not enough money in the CD
                    System.out.println("ERROR: Withdrawing too much");
                }
        }   
        else
        {
                System.out.println("NOT WITHIN ROLLOVER DATE");
                if(amount + penalty <= accountTotal)
                {
                    System.out.println("You Withdraw " + amount + " and a $" + penalty + " fee");
                    double totalRemoved = amount + penalty;//Adding the withdraw amount and the fee
                    accountTotal -= totalRemoved;
                    System.out.println("CD Total $" + accountTotal);
                }
                else
                {
                    System.out.println("ERROR: Withdrawing too much");
                }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingaccountstructure;

import java.util.Calendar;
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
    
    public CD(int accNum, int custID, int length, int rday, int rmonth, int ryear, double amount)
    {
        super(accNum, custID);
        CDlength = length;
        rollOverDay = rday;
        rollOverMonth = rmonth;
        rollOverYear = ryear;
        accountTotal = amount;
    }
    
    public void setRollOverDate(int srday, int srmonth, int sryear)
    {
        rollOverDay = srday;
        rollOverMonth = srmonth;
        rollOverYear = sryear;
    }
    
    public void setActive(int act)
    {
        active = act;
    }
    
    @Override
    public void withdraw(double amount)
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        
        int currentDay = localCalendar.get(Calendar.DATE);
        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
        int currentYear = localCalendar.get(Calendar.YEAR);
        int counter = 1;//USED TO STEP THROUGH SWITCH
        int finished = 0;
        //DETERMINE IF THEY ARE WITHDRAWING WITHING THE TIME FRAME
        while(finished == 0)
        {
        switch(counter)
        {
            case 1:
                if(currentYear == rollOverYear)
                {
                    counter = 2;
                }
                else
                {
                    counter = 10;
                }
                break;
            case 2:
                if(currentMonth == rollOverMonth)
                {
                    counter = 3;
                }
                else
                {
                    counter = 10;
                }
                break;
            case 3:
                if(currentDay <= rollOverDay && currentDay >= (rollOverDay - TIME_FRAME))
                {
                    counter = 9;
                }
                else
                {
                    counter = 10;
                }
                break;
            case 9:
                /*
                 * THE USER IS WITHIN THE AMOUNT OF DAYS TO WITHDRAW THE CD
                 */
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
                finished = 1;
                break;
            case 10:
                /*
                 * USER IS OUT OF THE WITHDRAW DATE
                 */
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
                finished = 1;
                break;
        }
        }
    }
}

package accounts;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Nic
 */
public class Loans extends Account
{
    protected double MONTHLY_PAYMENT;
    protected double interestRate;
    protected double paymentLeft;//payment amount still needed to be made for the month
    protected int paymentDay, paymentMonth, paymentYear;
    protected int daySince, monthSince, yearSince;//Date for payment since
    protected int paymentOverdue = 0; //0 for no, 1 for yes
    protected int paymentIncomplete = 0;//0 for no, 1 for yes
    protected double amountLeftInLoan;
    
    public Loans(int accNum, int custID, double accTot, String accType, double mpay, double interestRate)
    {
        super(accNum, custID, accTot, accType);
        this.interestRate = interestRate;
        amountLeftInLoan = accTot;
        MONTHLY_PAYMENT = mpay;
        paymentLeft = mpay;
    }
    
    public Date getLastPaymentDate()
    {
        Date lastPaymentDate = new Date(yearSince, monthSince, daySince);
        return lastPaymentDate;
    }
    
    public Date getPaymentDate()
    {   
        Date paymentDate = new Date(paymentYear, paymentMonth, paymentDay);
        return paymentDate;
    }
    
    public void setLastPaymentDate(int day, int month, int year)
    {
        daySince = day;
        monthSince = month;
        yearSince = year;
    }
    
    public void setPaymentDate(int day, int month, int year)
    {
        paymentDay = day;
        paymentMonth = month;
        paymentYear = year;
    }
    
    public double makePayment(double amount)
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        
        daySince = localCalendar.get(Calendar.DATE);
        monthSince = localCalendar.get(Calendar.MONTH);
        yearSince = localCalendar.get(Calendar.YEAR);
        
        Date paymentDate = new Date(paymentYear, paymentMonth, paymentDay);
        
        if(amount >= paymentLeft)
        {
            paymentLeft = 0;
            amountLeftInLoan -= amount;
            paymentIncomplete = 0;
            paymentOverdue = 0;
            System.out.println("You paid: $" + amount);
            System.out.println("Loan Balance: $" + amountLeftInLoan);
        }
        else if(amount <= 0)
        {
            System.out.println("Payment amount incorrect");
        }
        else
        {
            paymentIncomplete = 1;
            amountLeftInLoan -= amount;
            paymentLeft -= amount;
            System.out.println("You paid: $" + amount);
            System.out.println("Loan Balance: $" + amountLeftInLoan);
            System.out.println("WARNING, you must still pay $" + paymentLeft + " by " + paymentDate);
        }
        return accountTotal;
    }
    
            @Override
    public Account search(int findID){
                String statement = "SELECT * FROM " + databaseCallTableName + " WHERE " + databaseCallAccountNumber + " = " + findID;

                try{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next()){
                            this.accountNumber = res.getInt("accountID");
                            this.accountTotal = res.getDouble("TotalAmt");
                            this.accountOpen = res.getInt("Active");
                            this.interestRate = res.getDouble("Interest");
                            this.MONTHLY_PAYMENT = res.getDouble("Monthly");
                            this.amountLeftInLoan = res.getDouble("CurrAmt");
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return this;
        } 
}

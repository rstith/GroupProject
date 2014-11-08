/*This class is designed to handle the transaction logs from the various accounts.
 * Savings, Credit Card, Checking each have a table associated with them, and this
 * class takes each record selected and creates an object of it.
 * 
 * Attributes:
 * 
 * Date TransDate = Date transaction occurred. Reference Java Date object
 * String Description = Why transaction occurred
 * double Value = Amount of money being transferred
 * int Account = Number of the account associated with this record. Savings, Credit Card, or Checking account #
 * int TransactionID = the unique identifier of this transaction
 * 
 * Methods:
 * 
 * Transaction(): Empty constructor, initializes everything to 0, null, or empty string
 * Transaction(Date, String, double, int, int). In the order of the attributes above
 * List<Transaction> rsToTransactionList(ResultSet): turns a ResultSet into a transaction list. You probably won't use this
 * 
 */
package bankHW;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Transaction {

	public Date TransDate;
	public String Description;
	public double Value;
	public int Account;
	public int TransactionID;
	
	public Transaction()
	{
		TransDate = null;
		Description = "";
		Value = 0;
		Account = 0;
		TransactionID = 0;
	}
	
	public Transaction(int TransID, Date myDate, String Desc, double myVal, int Acct)
	{
		TransactionID = TransID;
		TransDate = myDate;
		Description = Desc;
		Value = myVal;
		Account = Acct;
	}
	
	public List<Transaction> rsToTransactionList(ResultSet res)
	{
		List<Transaction> transList = new ArrayList<Transaction>();
		try
		{
			Transaction trans = new Transaction();
			while (res.next())
			{
				trans.TransactionID = res.getInt(1);
				trans.TransDate = res.getDate(2);
				trans.Description = res.getString(3);
				trans.Value = res.getDouble(4);
				trans.Account = res.getInt(5);
				transList.add(trans);
	
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return transList;
	}
}

/* This class creates an object that will manipulate savings records
 * 
 * Attributes:
 * 
 * int CustNum - Number of the customer who owns this savings account
 * double Interest - Amount of interest this account earns
 * int Account - Unique identifier for this savings account
 * double Value - Balance of this savings account
 * double Overdraft - amount of overdraft protection authorized for this account
 * Date OpenDate - Date this account was opened
 * Boolean Active - Flag for open/closed accounts
 * 
 * Methods:
 * 
 * Savings() - Empty constructor, initializes everything to 0 or null
 * Savings (int, double, int, double, double, Date, Boolean) - Full-data constructor, accepts data in order described above
 * Savings getRecord(int AcctNum) - accepts unique savings account number, returns Savings object with all information
 * List<Transaction> getAllTrans(int Account) - Returns a list of all transactions associated with the passed-in Account number, as ArrayList
 * void addTrans(Transaction) - Takes Transaction object passed in, adds information to savings transaction table
 * void updateSavings(Savings) - Takes Savings object of already-existing account, updates table with new information
 * void newRecord(Savings) - Takes Savings object, creates a new Savings account with information
 * List<Savings> allAccounts() - Returns an ArrayList of all Savings accounts, as Savings objects
 * 
 */
package bankHW;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Savings {

	SQLDriver db = new SQLDriver();
	public int CustNum;
	public double Interest;
	public int Account;
	public double Value;
	public double Overdraft;
	public String OpenDate;
	public Boolean Active;
	
	public Savings(int Cust, double Int, int Acct, double Val, double Over, String myDate, Boolean isOpen)
	{
		CustNum = Cust;
		Interest = Int;
		Account = Acct;
		Value = Val;
		Overdraft = Over;
		OpenDate = myDate;
		Active = isOpen;
	}
	
	public Savings()
	{
		CustNum = 0;
		Interest = 0;
		Account = 0;
		Value = 0;
		Overdraft = 0;
		OpenDate = null;
		Active = true;
	}
	
	public Savings getRecord(int AcctNum)
	{
		String statement = "SELECT * FROM savings WHERE AcctID = "+AcctNum;
		ResultSet res = (ResultSet)db.select(statement);
		Savings sav = new Savings();
		try
		{
			while (res.next())
			{
				sav.Account = res.getInt(1);
				sav.Interest = res.getDouble(2);
				sav.Value = res.getDouble(3);
				sav.Overdraft = res.getDouble(4);
				sav.OpenDate = res.getString(5);
				sav.Active = res.getBoolean(6);
				sav.CustNum = res.getInt(7);
			}
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return sav;
	}
	
	public List<Transaction> getAllTrans(int Account)
	{
		String statement = "SELECT * FROM savingsrecord WHERE AccountNum ="+Account;
		List<Transaction> transList = new ArrayList<Transaction>();
		ResultSet res = (ResultSet)db.select(statement);
		Transaction trans = new Transaction();
		try
		{
			while (res.next())
			{
				trans = new Transaction();
				trans.TransactionID = res.getInt(1);
				trans.TransDate = res.getString(2);
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
	
	public void addTrans(Transaction trans)
	{
		String statement = "INSERT INTO savingsrecord VALUES ("+trans.TransactionID+",\""+trans.TransDate+"\",\""+trans.Description+"\","+trans.Value+","+trans.Account+");";
		System.out.println(statement);
		db.insert(statement);
	}
	
	public void updateSavings(Savings myRecord)
	{
		String statement = "UPDATE savings SET Owner = "+myRecord.CustNum+",Interest ="+myRecord.Interest+", Balance="+myRecord.Value+",Overdraft="+myRecord.Overdraft+",Opened=\""+myRecord.OpenDate+"\",Active="+myRecord.Active+" WHERE AcctID = "+myRecord.Account;
		System.out.println(statement);
		db.insert(statement);
	}
	
	public void newRecord(Savings newSavings)
	{
		String statement = "INSERT INTO savings VALUES ("+newSavings.Account+","+newSavings.Interest+","+newSavings.Value+","+newSavings.Overdraft+",\""+newSavings.OpenDate+"\","+newSavings.Active+","+newSavings.CustNum+");";
		db.insert(statement);
	}
	
	public List<Savings> allAccounts()
	{
		String statement = "SELECT * FROM savings";
		ResultSet res = (ResultSet)db.select(statement);
		List<Savings> savArray = new ArrayList<Savings>();
		try{
			while (res.next())
			{
				Savings sav = new Savings(res.getInt(7),res.getDouble(2), res.getInt(1), res.getDouble(3), res.getDouble(4), res.getString(5), res.getBoolean(6));
				savArray.add(sav);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return savArray;
	}

}

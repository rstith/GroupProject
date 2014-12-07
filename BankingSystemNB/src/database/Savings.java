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
 * void updateRecord(Savings) - Takes Savings object of already-existing account, updates table with new information
 * void addRecord(Savings) - Takes Savings object, creates a new Savings account with information
 * void deleteRecord(int) - Takes savings account ID as integer, deletes associated record from database
 * void deleteRecord(Savings) - Takes Savings object, deletes associated record from database
 * List<Savings> getAllAccounts(int) - accepts customer ID as int, returns all owner's savings accounts as an arraylist of Savings objects
 * List<Transaction> getAllTrans(int Account) - Returns a list of all transactions associated with the passed-in Account number, as ArrayList
 * void addTrans(Transaction) - Takes Transaction object passed in, adds information to savings transaction table
 * void getTrans(int) - Accepts transaction ID as int, returns associated record as Transaction object
 * void deleteTrans(int) - Accepts transaction ID as int, removes associated record from database
 * 
 * List<Savings> allAccounts() - Returns an ArrayList of all Savings accounts, as Savings objects
 * 
 */
package database;

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
		String statement = "SELECT * FROM savings WHERE AccountID = "+AcctNum;
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
		String statement = "SELECT * FROM savingsrecord WHERE AccountID ="+Account;
		List<Transaction> transList = new ArrayList<Transaction>();
		ResultSet res = (ResultSet)db.select(statement);
		Transaction trans = new Transaction();
		try
		{
			while (res.next())
			{
				trans = new Transaction();
				trans.TransactionID = res.getInt(1);
				trans.Account = res.getInt(2);
				trans.TransDate = res.getString(3);
				trans.Description = res.getString(4);
				trans.Value = res.getDouble(5);
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
		String statement = "INSERT INTO savingsrecord VALUES ("+trans.TransactionID+","+trans.Account+",\""+trans.TransDate+"\",\""+trans.Description+"\","+trans.Value+");";
		System.out.println(statement);
		db.insert(statement);
	}
	
	public void updateRecord(Savings myRecord)
	{
		String statement = "UPDATE savings SET OwnerID="+myRecord.CustNum+", Interest="+myRecord.Interest+", Balance="+myRecord.Value+", Overdraft="+myRecord.Overdraft+", Opened=\""+myRecord.OpenDate+"\", Active="+myRecord.Active+" WHERE AccountID="+myRecord.Account+";";
		System.out.println(statement);
		db.insert(statement);
	}
	
	public void addRecord(Savings newSavings)
	{
		String statement = "INSERT INTO savings VALUES ("+newSavings.Account+","+newSavings.Interest+","+newSavings.Value+","+newSavings.Overdraft+",\""+newSavings.OpenDate+"\","+newSavings.Active+","+newSavings.CustNum+");";
		db.insert(statement);
	}
	
	public List<Savings> getAllAccounts(int CustID)
	{
		String statement = "SELECT * FROM savings WHERE CustID="+CustID+";";
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
	
	public void deleteRecord(int SavingsID)
	{
		String statement = "DELETE FROM savings WHERE AccountID = "+SavingsID;
		db.insert(statement);
	}
	
	public void deleteRecord(Savings oldSav)
	{
		String statement = "DELETE FROM savings WHERE AccountID = "+oldSav.Account;
		db.insert(statement);
	}
	
	public Transaction getTrans(int TransID)
	{
		String statement = "SELECT * from savingsrecord WHERE TransactionID = "+TransID;
		System.out.println(statement);
		ResultSet res = (ResultSet)db.select(statement);
		Transaction tempTrans = new Transaction();
		try{
			
			while (res.next())
			{
				tempTrans.TransactionID = res.getInt(1);
				tempTrans.Account = res.getInt(2);
				tempTrans.TransDate = res.getString(3);
				tempTrans.Description = res.getString(4);
				tempTrans.Value = res.getDouble(5);
			}
			return tempTrans;
		}
		catch (Exception ex)
		{
			
		}
		return null;
	}
	
	public void deleteTrans(int TransID)
	{
		String statement = "DELETE FROM savingsrecord WHERE TransactionID = "+TransID;
		db.insert(statement);
	}
}

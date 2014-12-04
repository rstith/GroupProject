/*This class handles the checking account table for the database
 * 
 * Attributes:
 * 
 * int OwnerID - Customer number associated with the owner of this checking account
 * int AccountID - Unique identifier for this particular checking account
 * double Balance - How much money is here
 * double Interest - How much money this account is taking in. If any
 * Date Opened - Date when account was opened
 * int SavingsAcct - Number of savings account attached to this checking account, for overdraft purposes
 * String Type - Gold/Diamond or ThatsMyBank. I don't care what notation you use, but be consistent
 * double AvgBal - average balance, for determining if this is a Gold/Diamond or ThatsMyBank account
 * boolean Active - Determining if this account has been shut down or not
 * 
 * Methods:
 * 
 * Checking() - empty constructor. Initializes everything to 0 or null or empty string
 * Checking(int, int, double, double, Date, int, String, double, boolean) - takes in data in order described above
 * Checking getRecord(int Account) - takes in an account number, returns the record associated with that number as a Checking object
 * List<Transaction> getAllTrans(int Account) - returns an ArrayList of Transaction objects, each of which is a transaction associated
 *   with the account number passed in
 * List<Checking> getAllRecords() - returns all checking accounts in the system, as an ArrayList of Checking objects
 * void insertRecord(Checking) - accepts an object of type Checking, and inserts the values into the checking table
 * void changeRecord(Checking) - accepts an object of type Checking, and changes the data related to that object, based on account number 
 * 
 */

package database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Checking {

	public int OwnerID;
	public int AccountID;
	public double Balance;
	public double Interest;
	public String Opened;
	public int SavingsAcct;
	public String Type;
	public double AvgBal;
	public boolean Active;
	
	SQLDriver db = new SQLDriver();
	
	public Checking()
	{
		OwnerID = 0;
		AccountID = 0;
		Balance = 0;
		Interest = 0;
		Opened = null;
		SavingsAcct = 0;
		Type = "";
		AvgBal = 0;
		Active = true;
	}
	
	public Checking(int Owner, int Account, double Bal, double Int, String Open, int Savings, String AcctType, double Average, boolean ActiveAcct)
	{
		OwnerID = Owner;
		AccountID = Account;
		Balance = Bal;
		Interest = Int;
		Opened = Open;
		SavingsAcct = Savings;
		Type = AcctType;
		AvgBal = Average;
		Active = ActiveAcct;
	}
	
	public Checking getRecord(int Account)
	{
		String statement = "SELECT * FROM checking WHERE AccountID = "+Account+";";
		ResultSet res = (ResultSet)db.select(statement);

		try
		{
			Checking check = new Checking();
			while (res.next())
			{
				check = new Checking(res.getInt(1), res.getInt(2), res.getDouble(3), res.getDouble(4), res.getString(5), res.getInt(6), res.getString(7), res.getDouble(8), res.getBoolean(9));
			}
			return check;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Transaction> getAllTrans(int Account)
	{
		String statement = "SELECT * FROM checkingrecord WHERE AccountID = "+Account;
		ResultSet res = (ResultSet)db.select(statement);
		Transaction trans = new Transaction();
		return trans.rsToTransactionList(res);
	}
	
	public List<Checking> getAllRecords()
	{
		String statement = "SELECT * FROM checking";
		ResultSet res = (ResultSet)db.select(statement);
		Checking check = new Checking();
		List<Checking> checkArray = new ArrayList<Checking>();
		try
		{
			while (res.next())
			{
				check.OwnerID = res.getInt(1);
				check.AccountID = res.getInt(2);
				check.Balance = res.getDouble(3);
				check.Interest = res.getDouble(4);
				check.Opened = res.getString(5);
				check.SavingsAcct = res.getInt(6);
				check.Type = res.getString(7);
				check.AvgBal = res.getDouble(8);
				check.Active = res.getBoolean(9);
				checkArray.add(check);
			}
		}
		catch (Exception ex)
		{
			
		}
		return checkArray;
	}
	
	public void addTrans(Transaction myTrans)
	{
		String statement = "INSERT INTO checkingrecord VALUES ("+myTrans.TransactionID+","+myTrans.Account+",\""+myTrans.TransDate+"\","+myTrans.Value+",\""+myTrans.Description+"\");";
		db.insert(statement);
	}
	
	public void addRecord(Checking newCheck)
	{
		String statement = "INSERT INTO checking VALUES ("+newCheck.OwnerID+","+newCheck.AccountID+","+newCheck.Balance+","+newCheck.Interest+",\""+newCheck.Opened.toString()+"\","+newCheck.SavingsAcct+",\""+newCheck.Type+"\","+newCheck.AvgBal+","+newCheck.Active+");";
		db.insert(statement);
	}
	
	public void updateRecord(Checking newCheck)
	{
		String statement = "UPDATE checking SET CustID="+newCheck.OwnerID+", Value="+newCheck.Balance+", Interest = "+newCheck.Interest+", Opened=\""+newCheck.Opened+"\", SavingsAcct="+newCheck.SavingsAcct+", Type=\""+newCheck.Type+"\", AvgBal="+newCheck.AvgBal+", Active="+newCheck.Active+" WHERE AccountID="+newCheck.AccountID;
		System.out.println(statement);
		db.insert(statement);
	}
	
	public void deleteRecord(Checking newCheck)
	{
		String statement = "DELETE FROM checking WHERE AccountID = " + newCheck.AccountID;

		db.insert(statement);
	}
	
	public void deleteTransaction(int TransID)
	{
		String statement = "DELETE FROM checkingrecord WHERE TransactionID = "+TransID;
		db.insert(statement);
	}
	
	public Transaction getTrans(int TransID)
	{
		String statement = "SELECT * from checkingrecord WHERE TransactionID = "+TransID;
		ResultSet res = (ResultSet)db.select(statement);
		Transaction tempTrans = new Transaction();
		try{
			
			while (res.next())
			{
				tempTrans.TransactionID = res.getInt(1);
				tempTrans.Account = res.getInt(2);
				tempTrans.TransDate = res.getString(3);
				tempTrans.Description = res.getString(5);
				tempTrans.Value = res.getDouble(4);
			}
			return tempTrans;
		}
		catch (Exception ex)
		{
			
		}
		return null;
	}
}

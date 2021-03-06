/*This class creates objects that handle Loan records
 * 
 * Attributes:
 * 
 * int OwnerID - Customer number of person who took out loan
 * int LoanID - unique identifier for this particular loan
 * String Type - Type of loan being issued. Be consistent with terminology
 * double Interest - Interest rate being paid on loan
 * double Monthly - Monthly payment required on loan
 * double Total - Total amount of loan
 * Date NextDue - Date of next payment due
 * double CurrAmt - Amount of loan still outstanding
 * boolean Flag - To indicate troubled loan, payments delinquent
 * Date LastFull - Date of last full monthly payment
 * 
 * Methods:
 * 
 * Loan() - empty constructor, initializes everything to 0, empty string, or null
 * Loan(int, int, String, double, double, double, Date, double, boolean, Date). full-data constructor, order as described above
 * List<Loan> getRecord(int OwnerID) - Accepts a customer number, returns a ListArray of Loan objects associated with that customer
 * void addRecord(Loan) - Accepts a Loan object, adds its data to the loan table
 * void updateRecord(Loan) - Loan object updates the table with the data associated with its Loan ID
 */

package database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Loan {

	public int OwnerID;
	public int LoanID;
	public String Type;
	public double Interest;
	public double Monthly;
	public double Total;
	public String NextDue;
	public double CurrAmt;
	public boolean Flag;
	public String LastFull;
	public boolean Active;
	SQLDriver db = new SQLDriver();
	
	public Loan()
	{
		OwnerID = 0;
		LoanID = 0;
		Type = "";
		Interest = 0;
		Monthly = 0;
		Total = 0;
		NextDue = null;
		CurrAmt = 0;
		Flag = false;
		LastFull = null;
		Active = false;
	}
	
	public Loan(int Owner, int Loan, String LoanType, double Int, double Month, double Ttl, String Next, double Current, boolean Flagged, String Last)
	{
		OwnerID = Owner;
		LoanID = Loan;
		Type = LoanType;
		Interest = Int;
		Monthly = Month;
		Total = Ttl;
		NextDue = Next;
		CurrAmt = Current;
		Flag = Flagged;
		LastFull = Last;
		Active = true;
	}
	
	
	public Loan(int Owner, int Loan, String LoanType, double Int, double Month, double Ttl, String Next, double Current, boolean Flagged, String Last, boolean Act)
	{
		OwnerID = Owner;
		LoanID = Loan;
		Type = LoanType;
		Interest = Int;
		Monthly = Month;
		Total = Ttl;
		NextDue = Next;
		CurrAmt = Current;
		Flag = Flagged;
		LastFull = Last;
		Active = Act;
	}
	
	public List<Loan> getAllRecords(int ownerID)
	{
		String statement = "SELECT * FROM loan WHERE CustID ="+OwnerID;
		ResultSet res = (ResultSet)db.select(statement);
		List<Loan> loanArray = new ArrayList<Loan>();
		Loan myLoan = new Loan();
		try
		{
			while (res.next())
			{
				myLoan = new Loan();
				myLoan.OwnerID = res.getInt(1);
				myLoan.LoanID = res.getInt(2);
				myLoan.Type = res.getString(3);
				myLoan.Interest = res.getDouble(4);
				myLoan.Monthly = res.getDouble(5);
				myLoan.Total = res.getDouble(6);
				myLoan.NextDue = res.getString(7);
				myLoan.CurrAmt = res.getDouble(8);
				myLoan.Flag = res.getBoolean(9);
				myLoan.LastFull = res.getString(10);
				myLoan.Active = res.getBoolean(11);
				loanArray.add(myLoan);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return loanArray;
	}
	
	public Loan getRecord(int loanID)
	{
		String statement = "SELECT * FROM loan WHERE AccountID ="+loanID;
		ResultSet res = (ResultSet)db.select(statement);
		Loan myLoan = new Loan();
		try
		{
			while (res.next())
			{
				myLoan = new Loan();
				myLoan.OwnerID = res.getInt(1);
				myLoan.LoanID = res.getInt(2);
				myLoan.Type = res.getString(3);
				myLoan.Interest = res.getDouble(4);
				myLoan.Monthly = res.getDouble(5);
				myLoan.Total = res.getDouble(6);
				myLoan.NextDue = res.getString(7);
				myLoan.CurrAmt = res.getDouble(8);
				myLoan.Flag = res.getBoolean(9);
				myLoan.LastFull = res.getString(10);
				myLoan.Active = res.getBoolean(11);
			}
			return myLoan;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public void addRecord(Loan newLoan)
	{
		String statement = "INSERT INTO loan VALUES ("+newLoan.OwnerID+","+newLoan.LoanID+",\""+newLoan.Type+"\","+newLoan.Interest+","+newLoan.Monthly+","+newLoan.Total+",\""+newLoan.NextDue+"\","+newLoan.CurrAmt+","+newLoan.Flag+",\""+newLoan.LastFull+"\", "+newLoan.Active+");";
		db.insert(statement);
	}
	
	public void updateRecord(Loan modLoan)
	{
		String statement = "UPDATE loan SET CustID="+modLoan.OwnerID+", Type = \""+modLoan.Type+"\", Interest = "+modLoan.Interest+", Monthly = "+modLoan.Monthly+", TotalAmt = "+modLoan.Total+", NextDue = \""+modLoan.NextDue+"\", CurrAmt = "+modLoan.CurrAmt+", Flag ="+modLoan.Flag+", LastFull =\""+modLoan.LastFull+"\", Active="+modLoan.Active+" WHERE AccountID = "+modLoan.LoanID+";";
		db.insert(statement);
	}
	
	public void deleteRecord(Loan oldLoan)
	{
		String statement = "DELETE FROM loan WHERE AccountID = " + oldLoan.LoanID;
		db.insert(statement);
	}
	
	public void addTrans(Transaction myTrans)
	{
		String statement = "INSERT INTO loanrecord VALUES ("+myTrans.TransactionID+","+myTrans.Account+",\""+myTrans.TransDate+"\","+myTrans.Value+",\""+myTrans.Description+"\");";
		db.insert(statement);
	}
	
	public void deleteTrans(Transaction oldTrans)
	{
		String statement = "DELETE FROM loanrecord WHERE TransactionID = "+oldTrans.TransactionID;
		db.insert(statement);
	}
	
	public Transaction getTrans(int TransID)
	{
		String statement = "SELECT * from loanrecord WHERE TransactionID = "+TransID;
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
	
	public List<Transaction> getAllTrans(int Account)
	{
		String statement = "SELECT * FROM loanrecord WHERE AccountID = "+Account;
		ResultSet res = (ResultSet)db.select(statement);
		Transaction trans = new Transaction();
		return trans.rsToTransactionList(res);
	}
}

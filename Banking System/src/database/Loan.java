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
	}
	
	public List<Loan> getRecord(int OwnerID)
	{
		String statement = "SELECT * FROM loan WHERE LoanID ="+LoanID;
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
				loanArray.add(myLoan);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return loanArray;
	}
	
	public void addRecord(Loan newLoan)
	{
		String statement = "INSERT INTO loan VALUES ("+newLoan.OwnerID+","+newLoan.LoanID+",\""+newLoan.Type+"\","+newLoan.Interest+","+newLoan.Monthly+","+newLoan.Total+",\""+newLoan.NextDue+"\","+newLoan.CurrAmt+","+newLoan.Flag+",\""+newLoan.LastFull+"\");";
		db.insert(statement);
	}
	
	public void updateRecord(Loan modLoan)
	{
		String statement = "UPDATE loan SET OwnerID="+modLoan.OwnerID+", Type = \""+modLoan.Type+"\", Interest = "+modLoan.Interest+", Monthly = "+modLoan.Monthly+", TotalAmt = "+modLoan.Total+", NextDue = \""+modLoan.NextDue+"\", CurrAmt = "+modLoan.CurrAmt+", Flag ="+modLoan.Flag+", LastFull =\""+modLoan.LastFull+"\" WHERE LoanID = "+modLoan.LoanID+";";
		db.insert(statement);
	}
}

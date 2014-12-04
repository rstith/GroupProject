/*This class handles the addition and monitoring of CDs to the database
 * 
 * Attributes:
 * 
 * int OwnerID - Customer # associated with the owner of this CD
 * int DepositID - unique identifier associated with this particular CD
 * double Balance - How much was deposited initially
 * double Interest - The interest rate associated with this CD
 * Date Maturity - Date when the CD is fully matured and ready for collection
 * Date Opened - Date when the CD was created
 * Date Rollover - Date at which point the CD will be closed and the money put into a new CD
 * String Penalty - Description of penalty structure for early withdrawal
 * SQLDriver db - Used to connect to database 
 * 
 * Methods:
 * CD() - Default constructor. Initializes all to 0, empty string, or null
 * CD(int, int, double, double, Date, Date, Date, String) - full-data constructor, takes input in above order.
 * void addRecord(CD) - Takes an object of type CD, converts it and puts it into the CD table in the database
 * List<CD> getCDs(int Owner) - Accepts a customer number, returns a ListArray of CDs owned by customer
 * 
 */
package database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CD {

	public int OwnerID;
	public int DepositID;
	public double Balance;
	public double Interest;
	public String Maturity;
	public String Opened;
	public String Rollover;
	public String Penalty;
	SQLDriver db = new SQLDriver();
	
	public CD()
	{
		OwnerID = 0;
		DepositID = 0;
		Balance = 0;
		Interest = 0;
		Maturity = null;
		Opened = null;
		Rollover = null;
		Penalty = "";
	}
	
	public CD (int Owner, int Deposit, double Bal, double Int, String Mat, String Open, String Roll, String Pen)
	{
		OwnerID = Owner;
		DepositID = Deposit;
		Balance = Bal;
		Interest = Int;
		Maturity = Mat;
		Opened = Open;
		Rollover = Roll;
		Penalty = Pen;
	}
	
	public void addRecord(CD newCD)
	{
		String statement = "INSERT INTO cd VALUES ("+newCD.OwnerID+","+"0"+","+newCD.Balance+","+newCD.Interest+",\""+newCD.Maturity+"\",\""+newCD.Opened+"\",\""+newCD.Rollover+"\",\""+newCD.Penalty+"\");";
		db.insert(statement);
	}
	
	public void updateRecord(CD newCD)
	{
		String statement = "UPDATE cd SET CustID = "+newCD.OwnerID+", AccountID="+newCD.DepositID+", Value = "+newCD.Balance+", Interest="+newCD.Interest+", Maturity=\""+newCD.Maturity+"\", Opened=\""+newCD.Opened+"\", Rollover=\""+newCD.Rollover+"\", Penalty=\""+newCD.Penalty+"\" WHERE AccountID="+newCD.DepositID+";";
		System.out.println(statement);
		db.insert(statement);
	}
	
	public List<CD> getAllRecords(int Owner)
	{
		String statement = "SELECT * FROM cd WHERE CustID ="+Owner;
		ResultSet res = (ResultSet)db.select(statement);
		List<CD> cdArray = new ArrayList<CD>();
		CD newCD = new CD();
		try
		{
			while (res.next())
			{
				newCD = new CD();
				newCD.OwnerID = res.getInt(1);
				newCD.DepositID = res.getInt(2);
				newCD.Balance = res.getDouble(3);
				newCD.Interest = res.getDouble(4);
				newCD.Maturity = res.getString(5);
				newCD.Opened = res.getString(6);
				newCD.Rollover = res.getString(7);
				newCD.Penalty = res.getString(8);
				cdArray.add(newCD);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return cdArray;
	}
	
	public CD getRecord(int cdID)
	{
		String statement = "SELECT * FROM cd WHERE AccountID ="+cdID;
		ResultSet res = (ResultSet)db.select(statement);
		List<CD> cdArray = new ArrayList<CD>();
		CD newCD = new CD();
		try
		{
			while (res.next())
			{
				newCD = new CD();
				newCD.OwnerID = res.getInt(1);
				newCD.DepositID = res.getInt(2);
				newCD.Balance = res.getDouble(3);
				newCD.Interest = res.getDouble(4);
				newCD.Maturity = res.getString(5);
				newCD.Opened = res.getString(6);
				newCD.Rollover = res.getString(7);
				newCD.Penalty = res.getString(8);
				cdArray.add(newCD);
			}
			return newCD;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public void deleteRecord(CD oldCD)
	{
		String statement = "DELETE FROM cd WHERE AccountID = "+oldCD.DepositID;
		db.insert(statement);
	}
}

/* This class is to handle the data from the Credit Card table in the database. It has methods to 
 * update, add, and view entries in that table, as well as its associated transaction table
 * 
 * Attributes:
 * int OwnerID - This is the customer ID associated with the owner of this account
 * int CardID - This is the unique identifier for this account
 * double Interest - interest rate set for account
 * double TotalCredit - Overall credit line offered, included open and used
 * double OpenCredit - Amount of credit available and not used
 * double UsedCredit - Amount owed on account
 * Date NextDue - Date the next payment must be made. Reference Java Date object
 * String Penalty - Description of the penalty structure for this account
 * SQLDriver db - This is how the object connects to the DB. Please don't touch
 * 
 * Methods:
 * 
 * CCard() - Empty constructor, initializes everything to 0, null, or empty string
 * CCard(int, int, double, double, double, double, Date, String). This is the full-data constructor, with the entries in the order above.
 * CCard getRecord(int CardID) - Returns a CCard object with the data associated with the account number.
 * void addRecord(CCard newCard) - Accepts a CCard object and adds the data to the credit card table.
 * void updateRecord(CCard, newCard) - Accepts a CCard object and uses its CardID to update its own record in the table.
 * List<Transaction> getAllTrans(int CardID) - Returns all transactions associated with the account number passed in. In ArrayList format
 * void addTrans(Transaction) - Takes a Transaction object and adds it to the credit card transaction table
 * 
 */
package bankHW;

import java.sql.*;
import java.util.List;


public class CCard {

	public int OwnerID;
	public int CardID;
	public double Interest;
	public double TotalCredit;
	public double OpenCredit;
	public double UsedCredit;
	public String NextDue;
	public String Penalty;
	SQLDriver db = new SQLDriver();
	
	public CCard()
	{
		OwnerID=0;
		CardID=0;
		Interest=0;
		TotalCredit=0;
		OpenCredit=0;
		UsedCredit=0;
		NextDue=null;
		Penalty="";
	}
	
	public CCard(int Owner, int Card, double Int, double Total, double Open, double Used, String Next, String Pen)
	{
		OwnerID = Owner;
		CardID = Card;
		Interest = Int;
		TotalCredit = Total;
		OpenCredit = Open;
		UsedCredit = Used;
		NextDue = Next;
		Penalty = Pen;
	}
	
	public CCard getRecord(int CardID)
	{
		String statement = "SELECT * FROM ccard WHERE CardID = "+CardID;
		ResultSet res = (ResultSet)db.select(statement);
		CCard card = new CCard();
		try
		{
			while (res.next())
			{
				card.OwnerID = res.getInt(1);
				card.CardID = res.getInt(2);
				card.Interest = res.getDouble(3);
				card.TotalCredit = res.getDouble(4);
				card.OpenCredit = res.getDouble(5);
				card.UsedCredit = res.getDouble(6);
				card.NextDue = res.getString(7);
				card.Penalty = res.getString(8);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return card;
		
	}
	
	public void addRecord(CCard newCard)
	{
		String statement = "INSERT INTO ccard VALUES ("+newCard.OwnerID+","+newCard.CardID+","+newCard.Interest+","+newCard.TotalCredit+","+newCard.OpenCredit+","+newCard.UsedCredit+",\""+newCard.NextDue+"\",\""+newCard.Penalty+"\");";
		db.insert(statement);
	}
	
	public void updateRecord(CCard modCard)
	{
		String statement = "UPDATE ccard SET OwnerID = "+modCard.OwnerID+", Interest = "+modCard.Interest+", TotalCredit = "+modCard.TotalCredit+", OpenCredit = "+modCard.OpenCredit+", UsedCredit = "+modCard.UsedCredit+", NextDue = \""+modCard.NextDue+"\", Penalty = \""+modCard.Penalty+"\";";
		db.insert(statement);
	}
	
	public List<Transaction> getAllTrans(int CardID)
	{
		String statement = "SELECT * FROM ccardrecord WHERE CardID = "+CardID;
		System.out.println(statement);
		ResultSet res = (ResultSet)db.select(statement);
		Transaction myTrans = new Transaction();

		return myTrans.rsToTransactionList(res);
	}
	
	public void addTrans(Transaction myTrans)
	{
		String statement = "INSERT INTO ccardrecord VALUES ("+myTrans.TransactionID+","+myTrans.Account+",\""+myTrans.TransDate+"\","+myTrans.Value+",\""+myTrans.Description+"\");";
		db.insert(statement);
	}
	
	public void Print()
	{
		System.out.println(OwnerID+CardID+Interest+TotalCredit+OpenCredit+UsedCredit+NextDue+Penalty);
	}
	
}

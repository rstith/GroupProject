/*This class maintains the records of the customers of this bank
 * 
 * Attributes:
 * 
 * String LName - Customer's last name
 * String FName - Customer's first name
 * int CustNum - Unique number associated with this customer
 * 
 * Methods:
 * 
 * Customer() - Empty constructor, initializes to empty strings and 0;
 * Customer(String, String, int). Accepts Last name, First name, Customer number in that order
 * Customer search(int) - Returns Customer object associated with passed in Customer Number
 * Customer search(String) - Returns Customer object associated with last name passed in
 * List<Customer> getAll() - Returns a list of all customers of this bank, as an ArrayList of Customer objects
 * void add(Customer) - Adds the passed-in Customer object to the Customer table
 * print and printall - Using for testing, don't worry about these
 */

package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Customer {
	
	SQLDriver db = new SQLDriver();
	
	String LName;
	String FName;
	int CustNum;
	
	public Customer(String Last, String First, int CustID)
	{
		LName = Last;
		FName = First;
		CustNum = CustID;
	}
	
	public Customer()
	{
		LName = "";
		FName = "";
		CustNum = 0;
	}
	
	public Customer search(int CustID)
	{
		String statement = "SELECT * FROM customer WHERE CustID ="+CustID;

		try
		{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next())
			{
				LName = res.getString(1);
				FName = res.getString(2);
				CustNum = res.getInt(3);
			}
			print();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return this;
	}
	
	public List<Customer> getAll()
	{
		String statement = "SELECT * FROM customer";

		List<Customer> custList = new ArrayList<Customer>();
		try{
		ResultSet res = (ResultSet)db.select(statement);
		while (res.next())
		{
			Customer cust = new Customer(res.getString(1), res.getString(2), res.getInt(3));
			custList.add(cust);
		}
		printall(custList);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return custList;
		
	}
	
	public Customer search(String LName)
	{
		String statement = "SELECT * FROM customer WHERE LName ="+LName;
		try
		{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next())
			{
				LName = res.getString(1);
				FName = res.getString(2);
				CustNum = res.getInt(3);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return this;
	}
	
	public void add(Customer newCust)
	{
		String statement = "INSERT INTO customer VALUES (\""+newCust.LName+"\",\""+newCust.FName+"\","+newCust.CustNum+");";
		db.insert(statement);
	}
	
	public void print()
	{
		System.out.println(LName+"   "+FName+"    "+CustNum);
	}
	
	public void printall(List<Customer> objectList)
	{
		int iterator = objectList.size();
		for (int x = 0;x<iterator;x++)
		{
			objectList.get(x).print();
		}
	}
}

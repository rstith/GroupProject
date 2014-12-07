/*This class exists as a way to list all customer accounts and their associated types
 * for the Customer class getCustomerAccounts method. It contains Customer ID, Account ID, and 
 * Account Type only, and has no functionality.
 */

package database;

public class CustomerAccounts {

	public int CustID;
	public int AccountID;
	public String AccountType;
	
	public CustomerAccounts()
	{
		CustID=0;
		AccountID=0;
		AccountType="";
	}
	
	public CustomerAccounts(int CNum, int ANum, String AType)
	{
		CustID=CNum;
		AccountID=ANum;
		AccountType=AType;
	}
}

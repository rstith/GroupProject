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

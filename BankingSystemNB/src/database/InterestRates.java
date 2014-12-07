/*InterestRates class is used to manipulate the interestrates table, which contains the
 * default interest rates which can be overridden individually as each account is opened.
 * It has no data of its own
 * 
 * Methods:
 * gets and sets function as you'd expect
 * 
 * double getCDRate()
 * void setCDRate(double)
 * 
 * double getLoanRat()
 * void setLoanRate(double)
 * 
 * double getCCardRate()
 * void setCCardRate(double)
 * 
 * double getSavingsRate()
 * void setSavingsRate(double)
 */


package database;
import java.sql.*;

public class InterestRates {

	SQLDriver db = new SQLDriver();
	public double getCDRate()
	{
		String statement = ("SELECT CDInterest FROM interestrates");
		ResultSet rs = (ResultSet)db.select(statement);
		try{
			rs.next();
			return (rs.getDouble(1));
			}
		catch(Exception ex)
		{}
		return -1;
	}
	
	public void setCDRate(double CDRate)
	{
		String statement = ("UPDATE interestrates SET CDInterest = "+CDRate);
		db.insert(statement);
	}
	
	public double getLoanRate()
	{
		String statement = ("SELECT LoanInterest FROM interestrates");
		ResultSet rs = (ResultSet)db.select(statement);
		try{
			rs.next();
			return (rs.getDouble(1));
			}
		catch(Exception ex)
		{}
		return -1;
	}
	
	public void setLoanRate(double LRate)
	{
		String statement = ("UPDATE interestrates SET LoanInterest="+LRate);
		db.insert(statement);
	}
	
	public double getCCardRate()
	{
		String statement = ("SELECT CardInterest FROM interestrates");
		ResultSet rs = (ResultSet)db.select(statement);
		try{
			rs.next();
			return (rs.getDouble(1));
			}
		catch(Exception ex){}
		return -1;
	}
	
	public void setCCardRate(double CardRate)
	{
		String statement = ("UPDATE interestrates SET CardInterest="+CardRate);
		db.insert(statement);
	}
	
	public double getSavingsRate()
	{
		String statement = ("SELECT SavingsInterest FROM interestrates");
		ResultSet rs = (ResultSet)db.select(statement);
		double temp = 0;
		try{
			rs.next();
			return rs.getDouble(1);
			}
		catch(Exception ex){}
		return temp;
	}
	
	public void setSavingsRate(double SRate)
	{
		String statement = ("UPDATE interestrates SET SavingsInterest="+SRate);
		db.insert(statement);
	}
}

/*This class is used for entering employee information into the database, including their
 * names, login information, and whether or not they are a manager.
 * 
 * data:
 * String LName - Employee's last name
 * String FName - Employee's first name
 * int EmpID - Employee's Employee ID number
 * String UName - Username for login
 * String Pass - Password for login
 * Boolean Manager - Whether or not employee is manager
 * 
 * Methods:
 * void addRecord(Employee) - Accepts an Employee object, adds information to database
 * void updateRecord(Employee) - Accept Employee object, updates existing database record matching EmpID
 * void deleteRecord(Employee) - Accepts Employee object, removes matching record from database
 * Employee getRecord(int EmpNum) - Accepts Employee number as int, returns Employee record matching employee ID
 * List<Employee> getAllRecords() - returns arraylist of Employees working here
 * boolean validLogin(String username, String password) - Accepts username and password, returns true if both match table data
 *  
 */

package database;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Employee {

	public String LName;
	public String FName;
	public int EmpID;
	public String UName;
	public String Pass;
	public Boolean Manager;
	SQLDriver db = new SQLDriver();
	
	public Employee()
	{
		LName="";
		FName="";
		EmpID=0;
		UName="";
		Pass="";
		Manager = false;
	}
	
	public Employee(String Last, String First, int EmpNum, String User, String Password, boolean Man)
	{
		LName=Last;
		FName=First;
		EmpID=EmpNum;
		UName=User;
		Pass=Password;
		Manager=Man;
	}
	
	public void addRecord(Employee newEmp)
	{
		String statement = "INSERT INTO employee VALUES (\""+newEmp.LName+"\", \""+newEmp.FName+"\", "+newEmp.EmpID+", \""+newEmp.UName+"\",\""+newEmp.Pass+"\", "+newEmp.Manager+");";
		System.out.println(statement);
		db.insert(statement);
	}
	
	public void updateRecord(Employee newEmp)
	{
		String statement = "UPDATE employee SET LName=\""+newEmp.LName+"\", FName=\""+newEmp.FName+"\", UName=\""+newEmp.UName+"\", Pass=\""+newEmp.Pass+"\", Manager="+newEmp.Manager+" WHERE EmpID="+newEmp.EmpID+";";
		System.out.println(statement);
		db.insert(statement);
	}
	
	public Employee getRecord(int EmpNum)
	{
		String statement = "SELECT * FROM employee WHERE EmpID="+EmpNum+";";
		ResultSet rs = (ResultSet)db.select(statement);
		Employee newEmp = new Employee();
		try{
			while (rs.next())
			{
				newEmp.LName=rs.getString(1);
				newEmp.FName=rs.getString(2);
				newEmp.EmpID=rs.getInt(3);
				newEmp.UName=rs.getString(4);
				newEmp.Pass=rs.getString(5);
				newEmp.Manager=rs.getBoolean(6);
			}
		}
		catch (Exception ex)
		{
			
		}
		return newEmp;
	}
	
	public List<Employee> getAllRecords()
	{
		String statement = "SELECT * FROM employee;";
		ResultSet rs = (ResultSet)db.select(statement);
		List<Employee> EmpList = new ArrayList<Employee>();
		Employee newEmp = new Employee();
		try
		{
			while(rs.next())
			{
				newEmp = new Employee();
				newEmp.LName=rs.getString(1);
				newEmp.FName=rs.getString(2);
				newEmp.EmpID=rs.getInt(3);
				newEmp.UName=rs.getString(4);
				newEmp.Pass=rs.getString(5);
				newEmp.Manager=rs.getBoolean(6);
				EmpList.add(newEmp);
			}
		}
		catch(Exception ex)
		{
			
		}
		return EmpList;
	}
	
	public void deleteRecord(Employee newEmp)
	{
		String statement = "DELETE FROM employee WHERE EmpID="+newEmp.EmpID+";";
		db.insert(statement);
	}
	
	public boolean validLogin(String user, String password)
	{
		String statement = "SELECT * FROM employee WHERE UName=\""+user+"\" AND Pass=\""+password+"\";";
		ResultSet rs = (ResultSet)db.select(statement);
		try{
			return rs.next();
		}
		catch(Exception ex)
		{}
		return false;
	}
}

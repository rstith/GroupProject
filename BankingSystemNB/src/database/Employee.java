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
}

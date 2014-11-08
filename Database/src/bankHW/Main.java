package bankHW;
import java.util.*;
import java.sql.Date;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			SQLDriver db = new SQLDriver();
			Scanner reader = new Scanner(System.in);
			int decision = 0;
			Customer cust = new Customer();
			java.util.Calendar cal = java.util.Calendar.getInstance();
			java.util.Date utilDate = cal.getTime();
			java.sql.Date sqlDate = new Date(utilDate.getTime());
			List<Loan> transList;
			Loan loan = new Loan();
			
			while (decision!=9)
			{
				System.out.println("Please make a menu selection");
				System.out.println("1. CCard test");
				System.out.println("2. Display all customers");
				//System.out.println("3. Display account");
				System.out.println("4. Display customer");
				System.out.println("5. Update customer name");
				System.out.println("9. Close");
				System.out.print("Choice:");
				decision = reader.nextInt();
				switch(decision)
				{
				case 1: 
					{
						/*
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
						 */
						
						System.out.println("Owner ID");
						int CustNum = reader.nextInt();
						System.out.println("Loan ID");
						int LoanNum = reader.nextInt();
						System.out.println("Loan Type");
						String Type = reader.next();
						System.out.println("Interest");
						double Interest = reader.nextDouble();
						System.out.println("Monthly Payment");
						double Monthly = reader.nextDouble();
						System.out.println("Total");
						double Total = reader.nextDouble();
						System.out.println("Next payment due");
						String NextDue = reader.next();
						System.out.println("Current Owed");
						double Owed = reader.nextDouble();
						System.out.println("Flagged");
						boolean Flag = reader.nextBoolean();
						System.out.println("Last Full Payment");
						String LastFull = reader.next();
						
						loan = new Loan(CustNum, LoanNum, Type, Interest, Monthly, Total, NextDue, Owed, Flag, LastFull);
						loan.updateRecord(loan);
						
						
						/*sav = new Savings(CustNum, Interest, Account, Balance, Overdraft, Open, true);
						
						sav2.updateSavings(sav);*/
						/*cd = new CD(CustNum, DepositID, Balance, Interest, Maturity, Open, Rollover, Penalty);
						//System.out.println(sav.getRecord(3).OpenDate);
						Transaction trans;
						System.out.println("Transaction ID");
						int TransID = reader.nextInt();
						System.out.println("Transaction Date");
						String TDate = reader.next();
						System.out.println("Description");
						String Desc = reader.next();
						System.out.println("Amount ");
						double Value = reader.nextDouble();
						System.out.println("Account");
						int Account = reader.nextInt();
						trans = new Transaction(TransID, TDate, Desc, Value, Account);
						//sav.addTrans(trans);
						*/
						transList = loan.getRecord(3);

						int size = transList.size();
						for (int x = 0;x<size;x++)
						{
							System.out.println(transList.get(x).LoanID);
						}
						/*
						System.out.print("Enter customer number");
						int Customer = reader.nextInt();
						System.out.print("Enter customer last name");
						String LName = reader.next();
						System.out.print("Enter customer first name");
						String FName = reader.next();*/
						//cust.add(LName, FName, Customer);
						break;
					}
				case 2:
				{
					/*System.out.print("Enter customer number");
					int Customer = reader.nextInt();
					System.out.print("Interest rate");
					double Interest = reader.nextDouble();
					System.out.print("Account number");
					int Account = reader.nextInt();
					System.out.print("Account balance");
					double Value = reader.nextDouble();
					System.out.println("Linked Savings Acct");
					int Savings = reader.nextInt();
					System.out.print("Allowed overdraft:");
					double Overdraft = reader.nextDouble();*/
					//Checking newcheck = new Checking(Customer, Account, Value, Interest, sqlDate.toString(), Savings, "TMB", 0, true);
					//newcheck.insertRecord(newcheck);
					Checking newcheck = new Checking();
					newcheck.getRecord(11);
					break;
				}
				case 3:
				{
					System.out.print("Enter account number");
					int Account = reader.nextInt();
					//db.DisplayAccount(Account);
					break;
				}
				case 4:
				{
					System.out.print("Enter customer number");
					int CustID = reader.nextInt();
					cust = cust.search(CustID);
					break;
				}
				case 5:
				{
					System.out.print("Enter customer account number:");
					int custAcct = reader.nextInt();
					System.out.print("Enter new First Name:");
					String First = reader.next();
					System.out.print("Enter new Last Name:");
					String Last = reader.next();
					//db.updateCustomer(custAcct, First, Last);
				}
				}

			}
			reader.close();
	}

}

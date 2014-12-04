package database;
import java.util.*;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			SQLDriver db = new SQLDriver();
			Scanner reader = new Scanner(System.in);
			int decision = 0;
			Customer cust = new Customer();
			java.util.Calendar cal = java.util.Calendar.getInstance();
			java.util.Date utilDate = cal.getTime();
			List<Loan> transList;
			Loan loan = new Loan();
			
			while (decision!=9)
			{
				System.out.println("Please make a menu selection");
				System.out.println("1. CCard test");
				//System.out.println("2. Display all customers");
				System.out.println("3. Add Customer");
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
						String TDate = reader.nextLine();
						System.out.println("Description");
						String Desc = reader.nextLine();
						System.out.println("Amount ");
						double Value = reader.nextDouble();
						System.out.println("Account");
						int Account = reader.nextInt();
						trans = new Transaction(TransID, TDate, Desc, Value, Account);
						//sav.addTrans(trans);
						*/
						transList = loan.getAllRecords(3);

						int size = transList.size();
						for (int x = 0;x<size;x++)
						{
							System.out.println(transList.get(x).LoanID);
						}
						/*
						System.out.print("Enter customer number");
						int Customer = reader.nextInt();
						System.out.print("Enter customer last name");
						String LName = reader.nextLine();
						System.out.print("Enter customer first name");
						String FName = reader.nextLine();*/
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
					System.out.println("Customer Number");
					int Account = reader.nextInt();
					System.out.println("Last Name");
					String LName = reader.next();
					System.out.println("First Name");
					String FName = reader.next();
					System.out.println("SSN");
					String SSN = reader.next();
					System.out.println("Street");
					String Street = reader.next();
					System.out.println("City");
					String City = reader.next();
					System.out.println("State");
					String State = reader.next();
					System.out.println("ZIP");
					String ZIP = reader.next();
					Customer cust2 = new Customer(LName, FName, Account, SSN, City, Street, State, ZIP);
					cust2.addRecord(cust2);
					//db.DisplayAccount(Account);
					break;
				}
				case 4:
				{
					System.out.print("Enter customer number");
					int CustID = reader.nextInt();
					cust = cust.search(CustID);
					System.out.println(cust.FName+" "+cust.LName+" "+ cust.CustNum+" "+cust.City+" "+cust.Street+" "+cust.ZIP+" "+cust.SSN);
					break;
				}
				case 5:
				{
					System.out.print("Enter customer account number:");
					int custAcct = reader.nextInt();
					System.out.print("Enter new First Name:");
					String First = reader.nextLine();
					System.out.print("Enter new Last Name:");
					String Last = reader.nextLine();
					//db.updateCustomer(custAcct, First, Last);
					break;
				}
				case 6:
				{
					DBTest test = new DBTest();
					test.Test();
					break;
				}
				case 7:
				{
					List<CustomerAccounts> CArray = new ArrayList<CustomerAccounts>();
					Customer newCust = new Customer();
					newCust = newCust.search(1);
					System.out.println(newCust.LName);
					CArray = newCust.getCustomerAccounts(newCust);
					for(int x=0;x<CArray.size();x++)
					{
						System.out.println(CArray.get(x).AccountType);
					}
				}
				}

			}
			reader.close();
	}

}

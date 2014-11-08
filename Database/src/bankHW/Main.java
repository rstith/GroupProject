package bankHW;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			SQLDriver db = new SQLDriver();
			Scanner reader = new Scanner(System.in);
			int decision = 0;
			Customer cust = new Customer();
			
			while (decision!=9)
			{
				System.out.println("Please make a menu selection");
				System.out.println("1. Add a new customer");
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
						System.out.print("Enter customer number");
						int Customer = reader.nextInt();
						System.out.print("Enter customer last name");
						String LName = reader.next();
						System.out.print("Enter customer first name");
						String FName = reader.next();
						//cust.add(LName, FName, Customer);
						break;
					}
				case 2:
				{
					System.out.print("Enter customer number");
					int Customer = reader.nextInt();
					System.out.print("Interest rate");
					double Interest = reader.nextDouble();
					System.out.print("Account number");
					int Account = reader.nextInt();
					System.out.print("Account balance");
					double Value = reader.nextDouble();
					System.out.print("Allowed overdraft:");
					double Overdraft = reader.nextDouble();
					System.out.print("Checking account to link");
					int Checking = reader.nextInt();
					String Date = "20141021";
					Customer newcust = new Customer(Customer, Interest, Account, Value, Overdraft, Checking, Date);
					cust.getAll();
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

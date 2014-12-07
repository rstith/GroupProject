package database;


public class DBTest {
			// TODO Auto-generated method stub

			DBTest()
			{
				
			}

			Customer newCust = new Customer("Plistensen", "Gardocky", 90211, "987654321", "300 Sesame St.", "Springfield","MO", "31005");
			CCard newCard = new CCard(90211, 4, 9.9, 100, 50, 50, "1900-12-13", "No Penalty", true);
			CD newCD = new CD(90211, 50, 1000, 9.9, "2050-01-02", "2010-01-02", "2050-01-07", "no penalty");
			Savings newSave = new Savings(90211, 9.9, 9999, 1000, 300, "2012-10-10", true);
			Checking newCheck = new Checking(90211, 9999, 1000, 9.9, "1999-10-11", 9999, "IMB", 1000, true);
			Loan newLoan = new Loan(90211, 9999, "Short", 9.9, 120.00, 10000, "2014-11-10", 9000, true, "2010-01-01", true);
			Transaction CheckTrans = new Transaction(9999, "2014-10-10", "For Adult Services", 9000, 9999);
			Transaction SavingsTrans = new Transaction(9999, "2014-10-10", "Standard Payment", 100, 9999);
			Transaction CardTrans = new Transaction(9999, "2014-10-10", "Hookers", 100, 4);
			
			public void Test(){
			newCust.addRecord(newCust);
			newCard.addRecord(newCard);
			newCD.addRecord(newCD);
			newSave.addRecord(newSave);
			newCheck.addRecord(newCheck);
			newLoan.addRecord(newLoan);
			newCard.addTrans(CardTrans);
			newCheck.addTrans(CheckTrans);
			newSave.addTrans(SavingsTrans);
			
			
			Customer myCust = newCust.search(90211);
			System.out.println(myCust.LName);

			CCard myCard = newCard.getRecord(4);
			System.out.println(myCard.OwnerID);
			Transaction myTrans = myCard.getTrans(9999);
			System.out.println(myTrans.Description);
			myCard.deleteTrans(myTrans);
			myCard.deleteRecord(myCard);
			
			CD myCD = newCD.getRecord(50);
			System.out.println(myCD.DepositID);
			myCD.deleteRecord(myCD);
			
			Savings mySave = newSave.getRecord(9999);
			System.out.println("Savings account ="+mySave.Account);
			Transaction savTrans = mySave.getTrans(SavingsTrans.Account);
			System.out.println("Savings Transaction = "+mySave.Account);
			mySave.deleteTrans(savTrans.Account);
			mySave.deleteRecord(mySave.Account);
			
			Checking myCheck = newCheck.getRecord(9999);
			System.out.println("Checking account = "+myCheck.AccountID);
			Transaction checkTrans = newCheck.getTrans(9999);
			System.out.println("Checking transaction = "+checkTrans.Account);
			myCheck.deleteTransaction(checkTrans.Account);
			myCheck.deleteRecord(myCheck);
			
			Loan myLoan = newLoan.getRecord(9999);
			System.out.println("Loan account = "+myLoan.LoanID);
			myLoan.deleteRecord(myLoan);
			
			myCust.delete(myCust.CustNum);
			}
}

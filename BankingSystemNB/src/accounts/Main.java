/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author Nic
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        Savings savings1 = new Savings(1, 1);
        savings1.credit(900);
        Checking checking1 = new Checking(1, 1, 1000);
        
        savings1.credit(checking1.transferFunds(500, savings1));
        
        CD cd1 = new CD(1, 1, 12, 20, 10, 114, 1000); //DATE STARTS FROM  0-11
        cd1.withdraw(1000);
      
        System.out.println();
        
        Loans loan1 = new Loans(1, 1, 2000.0, 100);
        loan1.setPaymentDate(12, 10, 114);
        loan1.makePayment(25);
        loan1.makePayment(27);
        loan1.makePayment(100);
    }
}

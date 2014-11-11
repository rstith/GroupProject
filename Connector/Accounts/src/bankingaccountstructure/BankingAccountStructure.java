/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingaccountstructure;

/**
 *
 * @author Nic
 */
public class BankingAccountStructure 
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
        
        CD cd1 = new CD(1, 1, 12, 20, 11, 2014, 1000);
        cd1.withdraw(1000);
        
    }
}

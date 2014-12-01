package people;

/*
    This is the customer class. It inherits a lot of the characteristics of people. 
    That should be noted when pulling form the database.
    Some of these functions could be rewritten in the Person class.
*/


public class Customer extends Person {
        
	public Customer(){

		ID = 0;
		firstName = "";
		lastName = "";
		SSN = "";
		streetAddress = "";
		city = "";
		state = "";
		zipCode = "";
                
                databaseCallTableName = "customer";
                databaseCallLastName  = "LName";
                databaseCallID        = "CustID";

	}
	
	public Customer(int ID, String firstName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode){
		super(ID, firstName, lastName, SSN, streetAddress, city, state, zipCode);
                
                databaseCallTableName = "customer";
                databaseCallLastName  = "LName";
                databaseCallID        = "CustID";
	}
                	
}//End class Customer

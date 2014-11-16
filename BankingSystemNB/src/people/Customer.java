package people;

public class Customer extends Person {

	public Customer(){
	
	}
	
	public Customer(String ID, String firstName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode){
		super(ID, firstName, lastName, SSN, streetAddress, city, state, zipCode);
	}

}//End class Customer

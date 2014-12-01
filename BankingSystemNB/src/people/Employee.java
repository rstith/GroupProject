package people;

public class Employee extends Person {

	public Employee(){
	
	}
	
	public Employee(int ID, String firstName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode){
		super(ID, firstName, lastName, SSN, streetAddress, city, state, zipCode);
	}

}//End class Employee

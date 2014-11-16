package people;

public class Person extends People {

	/* Person - Subclass of the abstract class People. 
	 * Contains the characteristics of all people. 
	 *  - ID 	
	 *  - First Name
	 *	- Last Name
	 *	- Social Security Number
	 *	- Street Address
	 *	- City
	 *	- State
	 *	- Zip Code
	 *
	 * Contains the actions of all people.
	 *	- setID, getID
	 *	- setFirstName, getFirstName
	 *	- setLastName, getLastName
	 *	- setSSNumber, getSSNumber
	 *	- setStreetAddres, getStreetAddress
	 *  - setCity, getCity
	 *  - setState, getState
	 *  - setZipCode, getZipCode
	 * 
	 * Prints the Object
	 *  - print
	 */

	protected String ID;
	protected String firstName;
	protected String lastName;
	protected String SSN;
	protected String streetAddress;
	protected String city;
	protected String state;
	protected String zipCode;

	public Person(){
	
	}

	public Person(String ID, String firstName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode){
	
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;

	}
	
	//Set Variables
	public void setID(String ID){
		this.ID = ID;
		return;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;		
		return;
	}	

	public void setLastName(String lastName){
		this.lastName = lastName;
		return;
	}

	public void setSSN(String SSN){
		this.SSN = SSN;
		return;
	}

	public void setStreetAddress(String streetAddress){
		this.streetAddress = streetAddress;
		return;
	}

	public void setCity(String city){
		this.city = city;
		return;
	}

	public void setState(String state){
		this.state = state;
		return;
	}

	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
		return;
	}

	//Get Variables
	public String getID(){return ID;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getSSNumber(){return SSN;}
	public String getStreetAddress(){return streetAddress;}
	public String getCity(){return city;}
	public String getState(){return state;}
	public String getZipCode(){return zipCode;}

	//Print Person
	public void print(){
		System.out.printf("ID: %s | SSN: %s\n%s %s\n%s\n%s, %s %s\n", ID, SSN, firstName, lastName, streetAddress, city, state, zipCode);
	}

}//End class Person

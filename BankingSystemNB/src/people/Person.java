package people;

import database.SQLDriver;
import java.sql.ResultSet;

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
         * Search to Find Object
         *  - search (By ID)
      	 *  - search (By Last Name)
         *
	 * Prints the Object
	 *  - print
	 */

	protected int    ID;
	protected String firstName;
	protected String lastName;
	protected String SSN;
	protected String streetAddress;
	protected String city;
	protected String state;
	protected String zipCode;
        protected SQLDriver db = new SQLDriver();
        protected String databaseCallTableName;
        protected String databaseCallLastName;
        protected String databaseCallID;

	public Person(){
                this.ID = 0;
                this.firstName = "";
                this.lastName = "";
                this.SSN = "";
                this.streetAddress = "";
                this.city = "";
                this.state = "";
                this.zipCode = "";
                databaseCallTableName = "person";
                databaseCallLastName  = "LName";
                databaseCallID        = "personID";
	}

	public Person(int ID, String firstName, String lastName, String SSN, String streetAddress, String city, String state, String zipCode){
	
                this.ID = ID;
                this.firstName = firstName;
                this.lastName = lastName;
                this.SSN = SSN;
                this.streetAddress = streetAddress;
                this.city = city;
                this.state = state;
                this.zipCode = zipCode;
                
                databaseCallTableName = "person";
                databaseCallLastName  = "LName";
                databaseCallID        = "PersonID";

	}
	
	//Set Variables
	public void setID(int ID){
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
	public int    getID(){return ID;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getSSNumber(){return SSN;}
	public String getStreetAddress(){return streetAddress;}
	public String getCity(){return city;}
	public String getState(){return state;}
	public String getZipCode(){return zipCode;}
        
        //Search by ID
        public Person search(int findID){
                String statement = "SELECT * FROM " + databaseCallTableName + " WHERE " + databaseCallID + " = " + findID;

                try{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next()){
                            this.ID = res.getInt(databaseCallID);    
                            this.firstName = res.getString("FName");
                            this.lastName = res.getString("LName");
                            this.SSN = res.getString("SSN");
                            this.streetAddress = res.getString("Street");
                            this.city = res.getString("City");
                            this.state = res.getString("State");
                            this.zipCode = res.getString("Zip");
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return this;
        } 
        
        //Search by Last Name
        public Person search(String findLastName){
                String statement = "SELECT * FROM " + databaseCallTableName + " WHERE " + databaseCallLastName + " = " + findLastName;

                try{
			ResultSet res = (ResultSet)db.select(statement);
			while (res.next()){
                            this.ID = res.getInt(databaseCallID);    
                            this.firstName = res.getString("FName");
                            this.lastName = res.getString("LName");
                            this.SSN = res.getString("SSN");
                            this.streetAddress = res.getString("Street");
                            this.city = res.getString("City");
                            this.state = res.getString("State");
                            this.zipCode = res.getString("Zip");
	
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return this;
        } 

        //Add Person
        public void add(){
		String statement = "INSERT INTO "+databaseCallTableName+" VALUES ('"+this.lastName+"','"+this.firstName+"',"+this.ID+",'"+this.SSN+"','"+this.streetAddress+"','"+this.city+"','"+this.state+"','"+this.zipCode+"');";
		db.insert(statement);
	}
        
        //Delete Person
        public void delete(){
                String statement = "DELETE FROM "+databaseCallTableName+" WHERE "+databaseCallID+" = "+this.ID;
		db.insert(statement);
        }
        
	//Print Person
	public void print(){
		System.out.printf("ID: %d | SSN: %s\n%s %s\n%s\n%s, %s %s\n", ID, SSN, firstName, lastName, streetAddress, city, state, zipCode);
	}
}//End class Person

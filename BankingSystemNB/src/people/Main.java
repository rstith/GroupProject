package people;

public class Main {

	public static void main(String[] args){
	
		Person testPerson = new Person(1, "Jordan", "Fjellman", "239890983", "243 North Road St.", "Saint Joseph", "MO", "23451");
		Employee testEmployee = new Employee(1, "Jessica", "Fjellman", "234222345", "5243 North Road St.", "Saint Joseph", "MO", "23451");
		Manager testManager = new Manager(1, "Jaren", "Fjellman", "486638593", "2343 South St.", "Des Moines", "IA", "50022");
		Teller testTeller = new Teller(1, "Jacob", "Fjellman", "582756283", "1 West St.", "Saint Joseph", "MO", "23451");
		people.Customer testCustomer = new people.Customer(1, "Lily", "Fjellman", "363879283", "5243 East Road Ave.", "Atlantic", "IA", "50022");
                database.Customer testDBCustomer = new database.Customer("MyLastName", "MyFirstName", 0, "123456789", "123 Fake St.", "Nowhere", "MA", "11111");
                


		testPerson.print();
		System.out.println();
		testEmployee.print();
		System.out.println();
		testManager.print();
		System.out.println();
		testTeller.print();
		System.out.println();
		testCustomer.print();
                System.out.println();
                
                Customer searchCustomerTest = new Customer();
                
                //testCustomer.delete();
                //testCustomer.add();
                
                searchCustomerTest.search(6789);
                searchCustomerTest.print();
                
                testDBCustomer.search(6789);
		
	}//End method main

}//End class main

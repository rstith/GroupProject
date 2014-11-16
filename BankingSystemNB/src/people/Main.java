package people;

public class Main {

	public static void main(String[] args){
	
		Person testPerson = new Person("P00001", "Jordan", "Fjellman", "239890983", "243 North Road St.", "Saint Joseph", "MO", "23451");
		Employee testEmployee = new Employee("E00001", "Jessica", "Fjellman", "234222345", "5243 North Road St.", "Saint Joseph", "MO", "23451");
		Manager testManager = new Manager("M00001", "Jaren", "Fjellman", "486638593", "2343 South St.", "Des Moines", "IA", "50022");
		Teller testTeller = new Teller("T00001", "Jacob", "Fjellman", "582756283", "1 West St.", "Saint Joseph", "MO", "23451");
		Customer testCustomer = new Customer("C00001", "Lily", "Fjellman", "363879283", "5243 East Road Ave.", "Atlantic", "IA", "50022");



		testPerson.print();
		System.out.println();
		testEmployee.print();
		System.out.println();
		testManager.print();
		System.out.println();
		testTeller.print();
		System.out.println();
		testCustomer.print();
		
	}//End method main

}//End class main

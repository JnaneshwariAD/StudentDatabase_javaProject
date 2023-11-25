package sdbms;

public class Employee {

	String id;
	String name;
	
	static int count =101;
	
	Employee(String name){
		this.id= "Jsp"+count;
		this.name=name;
		count++;
	}
	
	public static void main(String[] args) {
		Employee e1=new Employee("Jnaneshwari");
		System.out.println("Id: "+e1.id+" "+"Name: "+e1.name);
		
		Employee e2=new Employee("Sneha");
		System.out.println("Id:"+e2.id+" "+"Name:"+e2.name);
	}
}

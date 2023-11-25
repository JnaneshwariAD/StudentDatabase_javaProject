package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customSorting.SortStudentById;
import customSorting.SortStudentByName;
import customSorting.StudentByMarks;
import customSorting.StudentbyAge;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner scan=new Scanner(System.in);

	Map<String , Student> db=new LinkedHashMap<String , Student>();

	@Override
	public void addStudent() {
		System.out.println("Enter Student Age:");
		int age=scan.nextInt();
		System.out.println("Enter the Name:");
		String name=scan.next();
		System.out.println("Enter Student Marks:");
		int marks=scan.nextInt();

		Student std=new Student(age, name, marks);
		db.put(std.getId(), std);

		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is "+std.getId());
	}

	@Override
	public void displayStudent() {
		//Accept student Id  -> jsp101 or JsP101 			//->toUpperCase()
		//check if id is there or not  -> containsKey()
		//if Id(key) is there -> get the value(student object)->getAge()....		
		//else customexception -> syudentNotFoundException invoke throw
		System.out.println("Enter the Student ID:");
		String id=scan.next();
		//string id=scan.next().toUpperCase();
		id=id.toUpperCase();

		
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
			//System.out.println(std);  //-> printing ref variable as tostring() is Overridden
		}
		else {
			try {
				String message="Student with Id "+id+" is Not Found!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}

	@Override
	public void displayAllStudents() {
		//convert Map into Set->keySet()
		//for each loop to traverse keys
		//db.get(key) -> getting value(student object) ->print reference
		if(db.size()!=0) {
			Set<String> keys=db.keySet();			//JSP101 JSP102
			for(String key:keys) {
				Student value=db.get(key);
				System.out.println(value);
				//System.out.println(db.get(key));
			}
		}
		else {	try {
				String message="Student Records Not Available to Display!!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override 
	public void removeStudent() {
		System.out.println("Enter student id:");
		String id= scan.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student record found!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted succesfully");
		}
		else {
			try {
				String message="Student with Id "+id+" is Not Found!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}

	@Override 
	public void removeAllStudents() {
		if(db.size()!=0) {
			System.out.println("Student Records Available: "+db.size());
			db.clear();
			System.out.println("All Student records Deleted Successfully");
			System.out.println("Student Records Available: "+db.size());
		}
		else {
			try {
				String message="Student Database is Empty!!!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student id:");
		String id= scan.next().toUpperCase();
		if(db.containsKey(id)){
			Student std=db.get(id);

			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter choice");
			int choice=scan.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("enter Age:");
				int age=scan.nextInt();
				std.setAge(age);
				break;
			case 2: 
				System.out.println("Enter Name:");
				String name=scan.next();
				std.setName(name);
				break;
			case 3: 
				System.out.println("enter marks:");
				int marks=scan.nextInt();
				std.setMarks(marks);
				break;
			default:
				try {
					String message="Invalid Choice Enter valid choice";
					throw new StudentNotFoundException(message);
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}


	@Override
	public void countStudent() {
		System.out.println("Number of Student records: "+db.size());
	}

	@Override
	public void sortStudent() {
		//map(db) into set->keys
		//List and ArrayList
		//for each=> Traverse key-> get the value(Student Object)and add int o list
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys)	{
				Student s=db.get(key) ;
				list.add(s);		}
			System.out.println("1:Sort By Student Id\n2:Sort By age\n3:Sort By name"); 
			System.out.println("4:Sort By marks\nenter Choice:");
			int choice=scan.nextInt();
			switch (choice) {
			case 1: 
				Collections.sort(list,new SortStudentById());
				for(Student s:list) {
					System.out.println(s);		}
				break;
			case 2: 
				Collections.sort(list,new StudentbyAge());
				for(Student s:list) {
					System.out.println(s);		}
				break; 
			case 3: 
				Collections.sort(list,new SortStudentByName());
				for(Student s:list) {
					System.out.println(s);		}
				break;
			case 4:
				Collections.sort(list,new StudentByMarks());
				for(Student s:list) {
					System.out.println(s);		}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}else {
			try {
				String message="No sufficient Student Object to Sort";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithLowestMarks() {
		//map into set
		//List all
		// for each
		// Collections.sort(list,marks)
		//sop(list.get(0)
		if(db.size()>= 2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys)	{
				list.add(db.get(key));
			}
			Collections.sort(list,new StudentByMarks());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message = "No Sufficient Student Objects to Compare!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		//map into set
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys)	{
				list.add(db.get(key));
			}
			Collections.sort(list,new StudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message="No Sufficient Student Object to campare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);

		StudentManagementSystem sMS=new StudentManagementSystemImpl();

		while(true) {
			System.out.println("Welcome to student DB Management System");
			System.out.println("Enter Your Choice");
			System.out.println("1.Add Student\n2.Display Student Detail\n3.Display All Student Detail\n4.Remove Student Details\n5.Remove All Students Details\n6.Update Student Details\n7.Count the Students\n8.Sort the Students\n9.Get the Student with lowest Marks\n10.Set the Student with Highest Marks\n11.EXIT");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				sMS.addStudent();
				break;
			case 2:
				sMS.displayStudent();
				break;
			case 3:
				sMS.displayAllStudents();
				break;
			case 4:
				sMS.removeStudent();
				break;
			case 5:
				sMS.removeAllStudents();
				break;
			case 6:
				sMS.updateStudent();
				break;
			case 7:
				sMS.countStudent();
				break;
			case 8:
				sMS.sortStudent();
				break;
			case 9:
				sMS.getStudentWithLowestMarks();
				break;
			case 10:
				sMS.getStudentWithHighestMarks();
				break;
			case 11:
				System.out.println("Thank You.....");
				System.exit(0);
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice, Enter Valid Choice!!!!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}//end of switch
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}//end of while loop
		
	}//end of main()

}//end of class
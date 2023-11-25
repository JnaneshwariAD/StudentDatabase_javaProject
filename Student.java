package sdbms;

public class Student {
	//4 private Data Members -> id, age, name, marks
	//constructor
	//3 setter and 4 getter methods
	//tostring -> Id:100 Age:......

	private String id;
	private int age;
	private String name;
	private int marks;

	static int count=101;
	Student(int age,String name,int marks){
		this.id="JSP"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks=marks;
	}
	
	@Override
	public String toString() {
		return "Id:"+id+" Age:"+age+" Name:"+name+" Marks:"+marks;
	}
}

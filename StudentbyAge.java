package customSorting;

import java.util.Comparator;

import sdbms.Student;

public class StudentbyAge implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		return x.getAge()-y.getAge();
	}

}

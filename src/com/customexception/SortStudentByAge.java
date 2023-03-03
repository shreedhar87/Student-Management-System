package com.customexception;

import java.util.Comparator;

import com.jspider.Student;

public class SortStudentByAge implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getAge()-y.getAge();
	}

}

package com.customexception;

import java.util.Comparator;

import com.jspider.Student;

public class SortStudentById implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getId().compareTo(y.getId());
	}

}

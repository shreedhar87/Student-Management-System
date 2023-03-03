package com.customexception;

import java.util.Comparator;

import com.jspider.Student;

public class SortStudentByMarks implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getMarks()-y.getMarks();
	}

}

package com.jspider;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidException;
import com.customexception.SortStudentByAge;
import com.customexception.SortStudentById;
import com.customexception.SortStudentByMarks;
import com.customexception.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Map<String,Student> map= new LinkedHashMap<String,Student>();

	Scanner scanner=new Scanner(System.in);

	@Override
	public void addStudent() {

		System.out.println("Enter the name");
		String username=scanner.next();

		System.out.println("Enter the age");
		int userage=scanner.nextInt();

		System.out.println("Enter the marks");
		int usermarks=scanner.nextInt();

		Student s=new Student(username, userage, usermarks);

		map.put(s.getId(), s);

		System.out.println("Student recort inserted successfully");
		System.out.println("Youer Student id is "+s.getId());

	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student id ");
		String sid="JPA:"+scanner.next();
		sid=sid.toUpperCase();

		if(map.containsKey(sid)) {
			System.err.println("your Student data is");
			Student obj=map.get(sid);
			System.out.println("Id:"+obj.getId());
			System.out.println("Name:"+obj.getName());
			System.out.println("Age:"+obj.getAge());
			System.out.println("Marks:"+obj.getMarks());

		}
		else {
			try {
				throw new StubNotFoundException("Student Record Not available to display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}

	@Override
	public void displayAllStudent() {

		Set<String>key=map.keySet();

		System.out.println("Student record as follows");
		System.out.println("--------------------");

		if(map.size()!=0) {
			for(String keys:key) {
				System.out.println(keys+" "+map.get(keys));
			}
		}
		else {
			try {
				throw new StubNotFoundException("Student Record Not available to display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent() {

		System.out.println("Enter the Student id to remove from list");
		String sid="JPA:"+scanner.next();
		sid=sid.toUpperCase();

		if(map.containsKey(sid)) {
			map.remove(sid);
			System.err.println("your Student data is removed successfully");
		}
		else {
			try {
				throw new StubNotFoundException("Student Record Not available to remove");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}
	@Override
	public void removeAllStudent() {

		Set<String>key=map.keySet();

		System.out.println("totale record as follows "+map.size());

		if(map.size()!=0) {
			/*	for(String keys:key) {
				map.remove(keys);				
			}*/
			map.clear();
			System.err.println("all the student records removed");
		}
		else {
			try {
				throw new StubNotFoundException("Student Record Not available to remove");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()	{
		System.out.println("Enter the id to update");
		int idd=scanner.nextInt();
		String getid="JPA:"+idd;

		getid=getid.toUpperCase();

		if(map.containsKey(getid)) {

			Student sd=map.get(getid);

			System.out.println("1.Update Name\n2.Update Age\n3.Update Marks\nEnter your choice");

			int choiceupdate=scanner.nextInt();

			switch(choiceupdate) {
			case 1:
				System.out.println("Enter the name to update");
				String nameupdate=scanner.next();
				sd.setName(nameupdate);
				System.out.println("Name update successfully");

				break;
			case 2:
				System.out.println("Enter the age to update");
				int ageupdate=scanner.nextInt();
				sd.setAge(ageupdate);
				System.out.println("Age update successfully");

				break;
			case 3:
				System.out.println("Enter the marks to update");
				int marksupdate=scanner.nextInt();
				sd.setMarks(marksupdate);
				System.out.println("Marks update successfully");

				break;

			default:
				try {
					throw new InvalidException("Invalid choice!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new StubNotFoundException("The value not in database to update");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override 
	public void countStudent() {
		System.out.println("Totale number of student is "+map.size());

	}
	@Override
	public void sortStudent() {
		
		List<Student> list=new ArrayList<Student>();
		
		Set<String>key=map.keySet();   //key set of map
		
		for(String s:key) {    //adding map collection
			list.add(map.get(s));  //adding map to list collection
		}
		
		System.out.println("1.Sort by Id\n2.Sort by Name\n3.Sort By Age\n4.Sort by Marks\nEnter your choice");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list, new SortStudentById());
			for(Student ss:list) {
				System.out.println(ss);
			}
			break;
		case 2:
			Collections.sort(list, new SortStudentByName());
			for(Student ss:list) {
				System.out.println(ss);
			}
			break;
		case 3:
			Collections.sort(list, new SortStudentByAge());
			for(Student ss:list) {
				System.out.println(ss);
			}
			break;
		case 4:
			Collections.sort(list, new SortStudentByMarks());
			for(Student ss:list) {
				System.out.println(ss);
			}
			break;
			default:
				try {
					throw new InvalidException("Invalid Choice!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}

	}
}

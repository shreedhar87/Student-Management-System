package com.jspider;

public class Student {
	private String id;
	private String name;
	private int age;
	private int marks;
	
	private static int count=101;
	
	Student(String name,int age,int marks){
		this.id="JPA:"+count;
		this.name=name;
		this.age=age;
		this.marks=marks;
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks +" of the students";
	}
	
}

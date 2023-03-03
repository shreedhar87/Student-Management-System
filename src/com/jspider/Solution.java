package com.jspider;

import java.util.Scanner;
import com.customexception.InvalidException;

public class Solution {
	public static void main(String[] args) {
		//upcasting for achieving abstraction
		StudentManagementSystem sms=new StudentManagementSystemImpl();

		//accept input from user
		Scanner scan=new Scanner(System.in);
		System.err.println("WELCOME TO STUDENT DATABASE MANAGEMENT SYSTEM\n------------------------------------------------");

		while(true) {
			System.out.print("1.Add Student\n2.Display Student\n3.Display All Student\n4.Remove Student\n5.Remove All Student\n6.Update Student\n7.Count Student\n8.Sort Student\n9.Exit from program\n\nEnter your choice-->");

			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				System.err.println("Thank You");
				System.exit(0);
				break;
			default:
				try {
					throw new InvalidException("invalid choice!");
				}
				catch(Exception e) {
					System.err.println(e.getMessage());
				}				
			}
			System.out.println("----------------------------"); //after switch choice
		}
	}

}

package example;

public class Employee {
	
	String id;
	String name;
	
	static int count=101;
	
	Employee(String name){
		this.id="jsp "+count;
		this.name=name;
		count++;
	}
	
	public static void main(String[] args) {
		Employee emp1=new Employee("Tom");
		System.out.println(emp1.id+"  "+emp1.name);
		
		Employee emp2=new Employee("Jerry");
		System.out.println(emp2.id+"  "+emp2.name);
		
		Employee emp3=new Employee("Bob");
		System.out.println(emp3.id+"  "+emp3.name);
	}
	

}

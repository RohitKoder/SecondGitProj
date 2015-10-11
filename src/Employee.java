import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class Employee implements Comparable<Employee>,Serializable{
	
	private static int id;
	private String name;
	private String address;
	private String temp;
	public void setTemp(String temp)
	{
		this.temp = temp;
	}
	public Employee() {
	}
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	Employee(String name,String address)
	{
		this.name = name;
		this.address = address;
	}
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		try {
			Employee e= new Employee("Rohit","Pune");
			Method[] mArr = Employee.class.getDeclaredMethods();
			
			for (Method m:mArr) {
				
					Object o = m.invoke("setTemp", "Dummy Value");
				
			}
			
			
			empList.add(e);
			empList.add(new Employee("Ranjit","Pune"));
			empList.add(new Employee("Rahul","Mumbai"));
			
			List<Employee> empListNew = new ArrayList<>();
			empListNew.add(new Employee("Rohit","Pune"));
			empListNew.add(new Employee("Girish","Pune"));
			empListNew.add(new Employee("Neha","Mumbai"));
			
			//	empList Intersection empListNew
			empList.retainAll(empListNew);
			System.out.println("Retain all ==\n"+empList);
			
			//	empList Union empListNew
			empList.addAll(empListNew);
			System.out.println("Add all ==\n"+empList);
			
			//	empList - empListNew
			empList.removeAll(empListNew);
			System.out.println("Remove all ==\n"+empList);
			
			Map<Integer, Employee> empMap = new TreeMap<>();
			empMap.put(2, new Employee("Karan","Pune"));
			empMap.put(1, new Employee("Amit","Pune"));
			empMap.put(3, new Employee("B","Pune"));
			System.out.println("Sorted Using TreeMap = \n"+empMap);
			
			Collections.sort(empListNew);
			System.out.println("Sorted using Collections = \n"+empListNew);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean equals(Object obj) {
		return (this.getName().equals(((Employee)obj).getName()) && this.getAddress().equals(((Employee)obj).getAddress()));
	}
	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return this.getName()+" "+this.getAddress();
	}
	
	
}

package com.practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SortingOrderingExample {

	public static void main(String[] args) {
		//distinctExample();
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(2, "B"));
		employees.add(new Employee(1, "A"));
		employees.add(new Employee(3, "C"));
		
		sortEmployeeById(employees);
		
	}
	
	private static void sortedExample() {
		
		Set<Integer> list = new HashSet<>(Arrays.asList(2,1,3));		
		Object[] objects = list.stream().sorted().toArray();
		System.out.println(Arrays.toString(objects));
		
	}

	private static void distinctExample() {
		
	    IntStream stream = IntStream.range(0, 1000000);
	    System.out.println(stream.unordered().parallel().distinct().count());
	    
	}
	
	private static void sortEmployeeById(List<Employee> employees) {
		
		employees.stream().sorted( (e1,e2) -> e1.getId()< e2.getId() ? -1 : e1.getId() >  e2.getId() ? 1 : 0 ).forEach(System.out::println);
	}
	
	
}


class Employee {
	
	int id;
	String name;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee Id : "+id+" Employee Name : "+name;
	}
	
	
}

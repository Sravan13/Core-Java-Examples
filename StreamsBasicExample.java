package com.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsBasicExample {

	public static void main(String[] args) {

		System.out.println(checkAllLessTen());
		//findingAllLessTen();
	}
	
	// Internal iteration
	
	static void internalIteration() {
		List<String> list = Arrays.asList("Apple", "Orange", "Banana");
		list.forEach(System.out::println);
	}
	
	// Counting even numbers in a list
	static long countEvensInTheList() {
		List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
		return list.stream().filter(i->(i%2==0)).count();
	}

	// Retrieving even number list	
	static List<Integer> RetrievingEvenNumberList() {
		List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
		return list.stream().filter(i->(i%2==0)).collect(Collectors.toList());
	}
	
	// Finding sum of all even numbers	
	void FindingSumOfAllEvenNumbers() {
		List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
		list.stream().filter(i->(i%2==0)).mapToInt(Integer::intValue).sum();
		
		//alternative
		List<Integer> list1 = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
		System.out.println(list1.stream().filter(i->(i%2==0)).reduce((i,j)->i+j));
	}
	
	// Finding whether all integers are less than 10 in the list
	static void findingAllLessTen() {
		List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
		System.out.println(list.stream().filter(i->(i<10)).collect(Collectors.toList()));
	}
	
	// check whether all integers are less than 10 in the list
	static boolean checkAllLessTen() {
		List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
		return list.stream().allMatch(i->(i<10));
	}
	
	
}

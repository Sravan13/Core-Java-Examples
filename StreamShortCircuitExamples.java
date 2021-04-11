package com.practice.stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream ShortCircuit operations are Limit, FindFirst, FindAny, anyMatch, allMatch, noneMatch
 */
public class StreamShortCircuitExamples {

	public static void main(String[] args) {
		limitingInfiniteStream();
	}
	
	private static void runWithLimit() {
		
		int[] ints = {1, 2, 3, 4, 5, 6};
		IntStream stream = Arrays.stream(ints);
		
		stream.filter(i->i%2==0).limit(2).forEach(System.out::println);
	}
	
	private static void findFirst() {
		
		int[] ints = {1, 2, 3, 4, 5, 6};
		IntStream stream = Arrays.stream(ints);
		
		OptionalInt optionalInt = stream.filter(i->i%3==0).findFirst();
		
		if(optionalInt.isPresent()) {
			System.out.println(optionalInt.getAsInt());
		}
		
	}
	
	private static void findAny() {
		
		int[] ints = {1, 2, 3, 4, 5, 6};
		IntStream stream = Arrays.stream(ints);
		
		OptionalInt optionalInt = stream.filter(i->i%3==0).findAny();
		
		if(optionalInt.isPresent()) {
			System.out.println(optionalInt.getAsInt());
		}
		
	}
	
	private static boolean allMatch() {
		
		Stream<String> stream = Stream.of("one", "two", "Three", "four");		
		return stream.allMatch(s-> (s.length()>0 && Character.isLowerCase(s.charAt(0))));

	}
	
	private static boolean anyMatch() {
	
		Stream<String> stream = Stream.of("one", "two", "Three", "four");		
		return stream.anyMatch(s-> (s.length()>0 && Character.isLowerCase(s.charAt(0))));
		
	}
	
	private static void limitingInfiniteStream(){
		
		Stream<Integer> stream = Stream.iterate(1, i -> i+1);
		stream.limit(5).forEach(System.out::println);
		
		 Stream<Integer> stream1 = Stream.iterate(1, i -> i + 1);
	        stream1.limit(5)
	              .filter(i -> i % 2 == 0)
	              .forEach(System.out::println);
	}

}

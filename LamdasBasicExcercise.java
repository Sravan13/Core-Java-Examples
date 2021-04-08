package lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LamdasBasicExcercise {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(new Person("a1", "a2", 1),
				new Person("b1", "b2", 2),
				new Person("c1", "c2", 3),
				new Person("d1", "d2", 4),
				new Person("e1", "e2", 5),
				new Person("f1", "f2", 6));
		
		// sort list by last name		
		Collections.sort(persons, (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));
		
		// print all the elements in the list
		persons.forEach(System.out::println);
		
		//print persons whose age is greater than 3
		printPersonOnCOndition(persons, p->p.getAge()>2,System.out::println);
		
	}
	
	public static void printPersonOnCOndition(List<Person> persons,Predicate<Person> predicate,Consumer<Person> consumer){
		
		for(Person person : persons) {
			if(predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}

}

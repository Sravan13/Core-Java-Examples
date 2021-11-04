package optional;

import java.util.Optional;

public class OptionalBasicExample {

	public static void main(String[] args) {
		
		Optional<String> name = Optional.of("Sravan");
		
		String answer1 = "Yes";
	    String answer2 = null;
	    
	    System.out.println("Non-Empty Optional:" + name);
	    System.out.println("Non-Empty Optional: name value : " + name.get());
        System.out.println("Empty Optional: " + Optional.empty());
        
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
        
        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

        
	}
	
	/*
	Optional.ofNullable() method returns a Non-empty Optional if a value present in the given object. Otherwise returns empty Optional.

	Optionaal.empty() method is useful to create an empty Optional object.
	
	*/
	
	private static void basicOptionalExamples() {
		
		Optional<String> name = Optional.of("Sravan");
		
		String answer1 = "Yes";
	    String answer2 = null;
	    
	    System.out.println("Non-Empty Optional:" + name);
	    System.out.println("Non-Empty Optional: name value : " + name.get());
        System.out.println("Empty Optional: " + Optional.empty());
        
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
        
        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
	}
	
	private static void OptionalMapFlapMapExample() {
		
		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();
		
		System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
		System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));
		
		Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
		System.out.println("Optional value   :: " + nonEmptyOptionalGender);
		System.out.println("Optional.map     :: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
		 System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));
		
	}
	
	private static void OptionalFilterExample() {
		
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();
        
        System.out.println(gender.filter(g->g.equals("male")));
        System.out.println(gender.filter(g->g.equalsIgnoreCase("male")));
        System.out.println(emptyGender.filter(g->g.equals("male")));
		
	}
	
	/*
	 * Optional.isPresent() returns true if the given Optional object is non-empty. Otherwise it returns false.

		Optional.ifPresent() performs given action if the given Optional object is non-empty. Otherwise it returns false.
	 */
	private static void OptionalIfPresentExample() {
		
		Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }

        gender.ifPresent(g -> System.out.println("In gender Option, value available."));

        //condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
		
	}
	
	private static void OptionalOrElseExample() {
		
	       	Optional<String> gender = Optional.of("MALE");
	        Optional<String> emptyGender = Optional.empty();

	        System.out.println(gender.orElse("<N/A>")); //MALE
	        System.out.println(emptyGender.orElse("<N/A>")); //<N/A>

	        System.out.println(gender.orElseGet(() -> "<N/A>")); //MALE
	        System.out.println(emptyGender.orElseGet(() -> "<N/A>")); //<N/A>
		
	}
	

}

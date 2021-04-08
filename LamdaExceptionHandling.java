package lamdas;

import java.util.function.BiConsumer;

public class LamdaExceptionHandling {

	public static void main(String[] args) {
		
		Integer [] numbers = {1,2,3,4,5,6};
		
		process(numbers, 0, (k,v)->System.out.println(k/v));
	}
	
	private static void process(Integer [] numbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		
		for(int num : numbers) {
			biConsumer.accept(num, key);
		}
		
	}
	
	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> biConsumer) {
		
		
			return (v,k)->{
				try {
				biConsumer.accept(v, k);
				
				}catch (ArithmeticException e) {
					e.printStackTrace();
				}
				
				};
		
		
	}

}

package com.practice.stream;

import java.time.LocalTime;
import java.util.stream.IntStream;
import static com.practice.stream.LogUtil.log;

public class LazySequentialParallelStream {

	public static void main(String[] args) {
		LazySequentialExample.run();
		
		System.out.println("Parallel execution :: ");
		
		LazyParallelExample.run();
	}
}


class LazySequentialExample {

    public static void run () {
    	
    	IntStream stream = IntStream.range(1, 5);
    	
    	stream = stream.peek(i -> log("starting", i)).filter(i->{
    		log("filtering", i); return i % 2 == 0;
    	}).peek(i -> log("post filtering", i));
    	
    	 log("Invoking terminal method count.");
		 log("The count is", stream.count());
    	
		
    }
}

class LazyParallelExample {

    public static void run () {
        IntStream stream = IntStream.range(1, 5).parallel();
        stream = stream.peek(i -> log("starting", i))
                       .filter(i -> {
                           log("filtering", i);
                           return i % 2 == 0;
                       })
                       .peek(i -> log("post filtering", i));
        log("Invoking terminal method count.");
        log("The count is", stream.count());
    }
}


class LogUtil {
    public static void log (Object... objects) {
        String s = LocalTime.now().toString();
        for (Object object : objects) {
            s += " - " + object.toString();
        }
        System.out.println(s);
        // just putting a little delay so that we can see a clear difference
        // with parallel stream
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

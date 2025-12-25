package start.ctci.java;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomSubset {

	public static void main(String[] args) {
		Random random = new Random();
		var list = List.of(1,2,3);		
		list.stream().filter(it-> random.nextBoolean()).collect(Collectors.toList());
	}
}

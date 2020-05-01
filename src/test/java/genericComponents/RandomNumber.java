package genericComponents;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomNumber {

	public static final int SET_SIZE_REQUIRED = 10;
	public static int NUMBER_RANGE = 100;

	@SuppressWarnings("unchecked")
	public static String getNumber(int size) 
	{
		Random random = new Random();
		@SuppressWarnings("rawtypes")
		Set set = new HashSet<Integer>(size+1);
		while (set.size() < size+1) 
		{
			while (set.add(random.nextInt(NUMBER_RANGE)) != true)
				;
		}
		assert set.size() == size+1;
		StringBuilder result = new StringBuilder();
		Iterator<Integer> itr = set.iterator();
		while (itr.hasNext()) {
			result.append(itr.next().toString());
		}
		return result.substring(1,size+1);
	}
}

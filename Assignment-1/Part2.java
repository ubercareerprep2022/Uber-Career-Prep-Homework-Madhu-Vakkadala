
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// Tests for Part 2 Question 1: String Permutation
		/**
		 * Implement the function isStringPermutation() that takes two Strings as
		 * parameters and returns a Boolean denoting whether the first string is a
		 * permutation of the second string.
		 */

		System.out.println(isStringPermutation("asdf", "fsa")); 	// false
		System.out.println(isStringPermutation("asdf", "fsda")); 	// true
		System.out.println(isStringPermutation("asdf", "fsax")); 	// false
		System.out.println(isStringPermutation("", "fsax")); 		// false
		System.out.println(isStringPermutation("asdf", "")); 		// false
		

		// Tests for Part 2 Question 2: Pairs that equal sum
		/**
		 * Implement the function pairsThatEqualSum() that takes an array of integers
		 * and a target integer and returns an array of pairs (i.e., an array of tuples)
		 * where each pair contains two numbers from the input array and the sum of each
		 * pair equals the target integer.
		 */

		List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(pairsThatEqualSum(test1, 5)); 			// return ((1,4), (2,3))

		List<Integer> test2 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(pairsThatEqualSum(test2, 1)); 			// return ()

		List<Integer> test3 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(pairsThatEqualSum(test3, 7)); 			// return ((2,5), (3,4))
		
		List<Integer> test4 = new ArrayList<>();
		System.out.println(pairsThatEqualSum(test4, 0)); 			// return ()
	}

	public static boolean isStringPermutation(String s1, String s2) {
		if (s1 == "" || s2 == "" || s1.length() != s2.length()) {
			return false;
		}

		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();

		Arrays.sort(s1Arr);
		Arrays.sort(s2Arr);

		for (int i = 0; i < s1.length(); i++) {
			if (s1Arr[i] != s2Arr[i]) {
				return false;
			}
		}

		return true;
	}

	public static List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum) {
		List<List<Integer>> toReturn = new ArrayList<>();
		if (inputArray == null) {
			return toReturn;
		}

		for (int i = 0; i < inputArray.size(); i++) {
			for (int j = i + 1; j < inputArray.size(); j++) {
				if (inputArray.get(i) + inputArray.get(j) == targetSum) {
					List<Integer> temp = new ArrayList<>();
					temp.add(inputArray.get(i));
					temp.add(inputArray.get(j));
					toReturn.add(temp);
				}
			}
		}

		return toReturn;
	}
}

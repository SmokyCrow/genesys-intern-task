package phone;

import java.util.ArrayList;
import java.util.List;

public class Combinator {
	// Mapping of digits to letters
	private static final String[] DIGIT_TO_LETTERS = {
			"", 	// 0
			"", 	// 1
			"abc", 	// 2
			"def",	// 3
			"ghi",	// 4
			"jkl",	// 5
			"mno",	// 6
			"pqrs",	// 7
			"tuv",	// 8
			"wxyz"	// 9
	};
	
	// Helper function for recursive backtracking
	public void backtrack(List<String> combinations, StringBuilder current, String digits, int index) {
		//Base case: if we reached the length of the input
		if(index == digits.length()) {
			combinations.add(current.toString());
			return;
		}
		
		//Getting the letters for the current digit
		String letters = DIGIT_TO_LETTERS[digits.charAt(index) - '0'];
		
		// Iterate over each letter for the current digit
		for(char letter : letters.toCharArray()) {
			current.append(letter);	// Adding the letter to the current combination
			backtrack(combinations, current, digits, index + 1); // Recurse to process the next digit
			current.deleteCharAt(current.length() - 1);	// Removing the last added letter for further exploration
		}
	}
	
	// Method to generate letter combinations
	public List<String> letterCombinations(String digits){
		// Input is empty, return empty list
		List<String> combinations = new ArrayList<>();
		if (digits == null || digits.isEmpty()) {
			return combinations;
		}
		
		// Backtracking process
		backtrack(combinations, new StringBuilder(), digits, 0);
		return combinations;
	};
	
	public static void main(String[] args) {
		Combinator combinator = new Combinator();
		System.out.println(combinator.letterCombinations("23"));
		System.out.println(combinator.letterCombinations(""));
		System.out.println(combinator.letterCombinations("429"));
	}
}

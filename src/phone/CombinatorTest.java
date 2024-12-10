package phone;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class CombinatorTest {
	@Test
	void testLetterCombinations() {
		Combinator combinator = new Combinator();
		
		List<String> result1 = combinator.letterCombinations("23");
		assertTrue(result1.containsAll(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
		
		List<String> result2 = combinator.letterCombinations("");
		assertTrue(result2.isEmpty());
		
		List<String> result3 = combinator.letterCombinations("2");
		assertTrue(result3.containsAll(List.of("a", "b", "c")));
		
		List<String> result4 = combinator.letterCombinations("429");
		assertTrue(result4.containsAll(List.of("gaw", "gax", "gay", "gaz", "gbw", "gbx", "gby", "gbz", "gcw", "gcx", "gcy", 
												"gcz", "haw", "hax", "hay", "haz", "hbw", "hbx", "hby", "hbz", "hcw", "hcx", 
												"hcy", "hcz", "iaw", "iax", "iay", "iaz", "ibw", "ibx", "iby", "ibz", "icw", "icx", "icy", "icz")));
		
		List<String> result5 = combinator.letterCombinations("8378");
		assertTrue(result5.contains("test"));
	}
	
}

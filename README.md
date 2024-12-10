# genesys-intern-task

This is my solution for the task, I will explain the main part of the solution more in detail below. The `Combinator.java` file has the solution code and a `main` function to try it out. The `CombinatorTest.java` file contains the unit tests.

## Backtracking Method

I used recursive backtracking to solve the problem, this seemed the most effective and compact for me, also this already puts the output in lexicographical order.

### 1. Input Parameters

- `combinations`: A list to collect all valid combinations, this is shared across the recursive calls

- `current`: A `StringBuilder` holding the current combination being constructed. This is modified as the recursion explores different paths.

- `digits`: The input string of digits, e.g., `"287"`.

- `index`: Tracks which digit we are currently processing, Starts at 0 and increments with each recursive call.

### 2. The Base Case

```java
if (index == digits.length()) {
    combinations.add(current.toString());
    return;
}
```

- The recursion stops when this condition is met.

- This happens when we've processed all the digits in the input string.

- If the condition is met, the constructed string is added to the `combinations` list, and we and this branch of recursion by returning to the previous call.

### 3. Processing the Current Digit

```java
String letters = DIGIT_TO_LETTERS[digits.charAt(index) - '0'];
```

- This part retrieves the letters for the current digit.

### 4. Iterating Over Letters

```java
for (char letter : letters.toCharArray()) {
    current.append(letter);
    backtrack(combinations, current, digits, index + 1);
    current.deleteCharAt(current.length() - 1);
}
```

1. `current.append(letter)`:
   
   * Add the letter to the combination being constructed.

2. Recursive call, `backtrack`:
   
   * Move to the next digit (`index + 1`) and repeat the process. 

3. `current.deleteCharAt(...)`:
   
   * Once the recursive call returns, remove the last letter.
   
   * This allows the function to explore the next letter for the current digit.

### Walkthrough Example: `digits = "23"`

1. First Call(`index = 0`)
   
   * Digit = `'2'` --> Letters = `"abc"`
   
   * Add `'a'` to `current` --> `current = "a"`
   
   * Recursive call for `index = 1`

2. Second Call(`index = 1`)
   
   * Digit = `'3'` --> Letters = `"def"`
   
   * Add `'d'` to `current` --> `current = "ad"`
   
   * Recursive call for `index = 2`

3. Third Call(`index = 2`)
   
   * Base case reached (`index == digits.length()`)
   
   * Add `"ad"` to `combinations`
   
   * Backtrack: Remove `'d'` --> `current = "a"`

4. Back to Second Call
   
   * Add `'e'` to `current` --> `current = "ae"`
   
   * Recursive call for `index = 2`.
   
   * Add `"ae"` to `combinations`.
   
   * Backtrack: Remove `'e'` --> `current = "a"`.  

5. Continue Exploration
   
   * Add `'f'` to `current` --> `current = "af"`
   
   * Recursive call for `index = 2`.
   
   * Add `"af"` to combinations.
   
   * Backtrack: Remove `'f'` --> `current = "a"`.

6. Back to First Call
   
   * Backtrack: Remove `'a'` --> `current = ""`.
   
   * Add `'b'` to `current` --> `current = "b"`
   
   * Repeat the same process for letters `'d'`, `'e'`, `'f'`.   

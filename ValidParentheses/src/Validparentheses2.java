import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Validparentheses2 {
	//Hash table good for mapping
	private static HashMap<Character, Character>mappings;
	//initialize mappings
	public Validparentheses2() {
		Validparentheses2.mappings = new HashMap<Character, Character>();
		Validparentheses2.mappings.put(')', '(');
		Validparentheses2.mappings.put('}', '{');
		Validparentheses2.mappings.put(']', '[');
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			//if current char is closing brackets 
			if(Validparentheses2.mappings.containsKey(c)) {
				//pop the top element of the stack. if stack is empty, set a dummy value
				char topElm = stack.empty() ? '#':stack.pop();
				//if the mapping for this bracket doesn't match the stack's top element, return false
				if(topElm != Validparentheses2.mappings.get(c)) {
					return false;
				}
				
			}else {
				//if it was an opening bracket, push to the stack
				stack.push(c);
			}
		}
		//if stack is still contains elements, then it is invalid expression
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter a parentheses pattern: ");
		try (Scanner input = new Scanner(System.in)) {
			String pattern = input.nextLine(); //parentheses pattern
			isValid(pattern);
		}
	}
}

import java.io.*; 
import java.util.*;

/*Busra Yasar
 * Given a string containing just the characters '(', ')', '{', '}', '[', ']', determine
 * if the input string is valid. An input string is valid if:
 * 1.Open brackets must be closed by the same type of brackets.
 * 2.Open brackets must be closed in the correct order.
 * 3.Note that an empty string is also considered valid. 
 * Examples:
 * 1. "()" -> true 
 * 2."()[]{}" ->true
 * 3."(]" -> false
 * 4."([)]" -> false
 * 5."{[]}" -> true
 * */
public class ValidParentheses {
	// Pushing element on the top of the stack 
    static void stack_push(Stack<String> stack, String c ) 
    { 
         stack.push(c);
         System.out.println("pushed"+ c); 
    }
    // Popping element from the top of the stack 
    static void stack_pop(Stack<String> stack) 
    {         
            String popped = (String) stack.pop(); 
            System.out.println("popped"+popped); 
    } 
 // Displaying element on the top of the stack 
    static String stack_peek(Stack<String> mystack) 
    { 
        String element = (String) mystack.peek(); 
        System.out.println("Element on stack top : " + element); 
        return element;
    }
    
	public static void main(String[] args) {
	System.out.println("Please enter a parentheses pattern: ");
	Scanner input = new Scanner(System.in);
	
	String pattern = input.nextLine(); //parentheses pattern
	 int len = pattern.length();
	
	Stack<String> mystack = new Stack<String>();// create a stack to hold parentheses
	
	String temp ="";
	
	for(int i=0; i<len; i++) {
		temp = String.valueOf(pattern.charAt(i)) ;
		System.out.println("temp: "+temp);
		
		if( temp.equals("(")  || temp.equals("{")  || temp.equals("[")  ) {
			stack_push(mystack, temp);		
		}else if(temp.equals(")") ) {
			if(stack_peek(mystack).equals("(") ) {
				stack_pop(mystack);
				
			}
			
		}else if( temp.equals("}") ) {
			 if(stack_peek(mystack).equals("{")) {
				 stack_pop(mystack);
				 
			}
			
		}else if( temp.equals("]") ){
			 if(stack_peek(mystack).equals("[")) {
				 stack_pop(mystack);
				 
			}
			
		}
		
			
		}
		
	if(mystack.empty() == true) {
		System.out.println("STACK IS VALID");
		
	}else if(mystack.empty() == false) {
		System.out.println("STACK IS NOT VALID");
	}
	
	
	}
}

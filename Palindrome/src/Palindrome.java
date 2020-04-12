/*Büþra Yaþar
 * Determine whether an integer is a palindrome (when it reads the same backward as forward.
 * Ex1: 121 -> 121 output:true Ex2: -121 -> 121- output:false Explanation: from left to right,
 * it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Bonus: could you solve it without converting the int to string?
 * */
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		String s="y";
		
		
		while(s.equalsIgnoreCase("y")) {
			
		
		System.out.println("Enter a number to check whether palindrome or not: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		
		if(input < 0 || (input % 10 == 0 && input != 0)) {
			System.out.println(input+ " is not palindrome.");
			
		}else if(input > 0) {
			int rev = reverse(input);
			if(input == rev) {
				System.out.println(input+ " is palindrome.");
			}else {
				System.out.println(input+ " is not palindrome.");
			}
			
			}
		System.out.println("Do you want to continue, enter 'Y' or 'N' :");
		Scanner choice = new Scanner(System.in);
		s = choice.nextLine();
		}

	}
	public static int reverse(int num) {
		int reverse =0;
		while(num != 0) {
			reverse = reverse*10 ;
			reverse = reverse + num %10;
			num = num / 10;
			
		}
		return reverse;
	}

}

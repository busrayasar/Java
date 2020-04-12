/*Büşra Yaşar 
 * Given a 32-bit signed integer, reverse digits of an integer. 
 * Exp: 123 -> 321 Exp: -123 -> -321 Ex: 120 -> 21 Note: Assume we are dealing with an environment 
 * which could only store integers within the 32-bit signed integer range: [-231, 231-1]. For the 
 * purpose of this problem, assume that your function returns 0 when the reversed integer overflows. 
 * */
import java.util.Scanner;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println("Please enter an integer:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		/*int x=1, y=1;
		while(num/x > 9) {
			x=x*10;
			y++;
		}
		System.out.println("Your number is "+ y + " digit" );
		*/
		int  reverse = 0;
		while(num != 0) {
			
			reverse = reverse*10;
			reverse = reverse + num%10;
			num =num/10;
			
		}
		if(reverse < (-231) || reverse > 230) {
			System.out.println(0 + " overflow");
			
		}else {
		System.out.println("Reversed number "+ reverse);
		}
	}

}

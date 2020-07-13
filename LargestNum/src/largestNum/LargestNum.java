package largestNum;

import java.util.Scanner;
//Busra Yasar- Compare 3 num and find the largest
public class LargestNum {
	static int num1;
	static int num2;
	static int num3;
	public static void main(String [] args) {
		
		for(int i=0; i<3; i++) {
			System.out.println("Please enter the "+ (i+1) +"th num:");
			Scanner sc = new Scanner(System.in);
			if(i == 0) {
				num1 = sc.nextInt();
			}else if(i ==1 ) {
				num2 = sc.nextInt();
			}else if(i == 2) {
				num3 = sc.nextInt();			
			}
		}	
		System.out.println("Your nums : "+ num1+ " "+ num2+" "+num3);
		
		if(num1 >= num2 && num1 >= num3) {
			System.out.println("The largest number is: "+ num1);
			
		}else if(num2 >= num3) {
			System.out.println("The largest number is: "+ num2);
		}else if(num3 > num2) {
			System.out.println("The largest number is: "+ num3);
		}
	}

}

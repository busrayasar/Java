

import java.util.Scanner;

//Büþra Yaþar
/*Given an array of integers, return indices of the two numbers such that they add up to a specific 
 * target. 
 * You may assume that each input would have exactly one solution, and you may not use the same element
 * twice. Example:
 * Given Nums = [2, 7, 11, 15] Target:9 Because Nums[0] + Nums[1] = 2+7 =9 return[0,1].
 * */
public class TwoSum2 {
	private static Scanner ln;
	private static Scanner elm;
	private static Scanner tg;

	public static void main(String[] args) {
	
	System.out.println("Enter the length of the array: ");
	ln = new Scanner(System.in);
	int  length =ln.nextInt();
	int[] nums = new int[length];

	for(int j=0; j<length; j++) {
		System.out.println("Please enter the element of the array:");
		elm = new Scanner(System.in);
		int eleman = elm.nextInt();
		nums[j]=eleman;	
	}
	
		System.out.println("Please enter target: ");
		tg = new Scanner(System.in);
		int target = tg.nextInt();
		
		int[] result = twoSum(nums , target);
		int rlen = result.length;
		for(int k=0; k<rlen; k++) {
			System.out.println("indices: " + result[k]);
		}
		
	}
	
	public static int[] twoSum(int[] nums, int target ) {
		
		for(int i = 0; i<nums.length; i++) {
			for(int j = i+1; j<nums.length; j++) {
				if (nums[j]== target - nums[i]) {
					return new int[] {i,j};
				}
		}
		
	}
	throw new IllegalArgumentException("No two sum solution");

}
	
}
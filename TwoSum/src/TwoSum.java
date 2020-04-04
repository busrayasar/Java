
import java.util.HashMap;
import java.util.Map;

//Busra yasar
/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,and you may not use the same element twice
 * Ex: Given Array=[2,7,11,15] Target =9 , nums[0] + nums[1] =9 
 * return [0,1]
 * */

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		int target = 20;
		
		
		twoSum(arr, target);

	}
	
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int complement = target -nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement),i};
			}
			map.put(nums[i],i);
		}
		throw new IllegalArgumentException("No two sum solution");
		
	}

}

package arraySum;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,3};
		int targ = 6;
		int[] result = findSums(nums,targ);
		System.out.println(result);
		
	}
	
	public static int[] findSums(int[] nums, int target) {
		HashMap<Integer,Integer> ints = new HashMap<>();
		Integer compIndex;
		int result [] = new int[2];
		
		for (int i=0;i<nums.length;i++) {
			//see if the complement to i is in our map
			compIndex = ints.get(target - nums[i]);
			if (compIndex==null) {
				//Complement not in map, so add this value and move on
				ints.put(nums[i],i);
			} else {
				//Found two numbers that add up to the total, so add them to the array and break out
				result[0] = compIndex;
				result[1] = i;
				break;
			}
		}
		return result;
	}
	
}		

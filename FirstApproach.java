package com.interviewprep.leetcode.medium.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstApproach {

	public static void main(String[] args) {
		
		
		//int[] nums = {1,0,-1,0,-2,2} ;
		//int target = 0;
		
		//int[] nums = {2,2,2,2,2,2};
		//int target = 8;
		
		int[] nums = {1000000000,1000000000,1000000000,1000000000};
		int target = -294967296;
		
		FirstApproach fa = new FirstApproach();
		List<List<Integer>> fourSum = fa.fourSum(nums, target);

		System.out.println(fourSum);
	}
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>>  fourSum = new ArrayList<List<Integer>>();	

		Arrays.sort(nums);

		int len = nums.length;

		for(int i=0; i<len-3; i++) {

			// skip duplicates
			if(i>0 && nums[i] == nums[i-1]) 
				continue;

			// skip duplicates
			for(int j=i+1; j<len-2; j++) {

				if (j > i + 1 && nums[j] == nums[j - 1]) 
					continue;


				int left = j+1;
				int right = nums.length-1;

				while(left < right) {

					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

					if(sum == target) {

						fourSum.add(Arrays.asList(nums[i] , nums[j], nums[left] , nums[right]));

						// skip duplicates
						while (left < right && nums[right] == nums[right - 1]) right--;
						while (left < right && nums[left] == nums[left + 1]) left++; 

						left++;
						right--;

					} //endif
					else if(sum < target) {

						left++;
					}
					else if(sum > target) {

						right--;
					}

				} // endwhile
			}				

		}// end outer for loop		 

		return fourSum;
	}

}

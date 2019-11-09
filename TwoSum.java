/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1]. */

import java.util.*;

class Solution {

    public int[] twoSum1(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        } 
    }

    public int[] twoSum2(int[] nums, int target) {
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            hashMap.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; ++i) {
            int difference = target - nums[i];
            if (hashMap.containsKey(difference) && hashMap.get(difference) != i) {
                return new int[] { i, hashMap.get(difference) };
            }
        }
        throw new IllegalArgumentException("No such elements in array.");
    }

    public int[] twoSum3(int[] nums, int target) {
    	HashMap<Integer, Integer> hashMap = new HashMap<>();

    	for (int i = 0; i < nums.length; ++i) {
    		int difference = target - nums[i];
    		if (hashMap.containsKey(difference)) {
    			return new int[] { hashMap.get(difference), i };
    		}
    		hashMap.put(nums[i], i);
    	}
    	throw new IllegalArgumentException("No such elements in array.");
    }

}
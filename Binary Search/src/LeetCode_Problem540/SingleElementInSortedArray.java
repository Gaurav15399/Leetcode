package LeetCode_Problem540;

/*
LeetCode URL - https://leetcode.com/problems/single-element-in-a-sorted-array/description/

Achieved Time Complexity in solution - OlogN

Problem Statement -:

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105


Problem Level - Medium
 */



public class SingleElementInSortedArray {

    public static void main(String[] args) {
        // Update the testcase in next line as per requirement .
        // The next line is written only for execution purpose.
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,4,4}));
    }

    //Actual Solution for leetcode problem
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            // The following code is for handling edge cases where you directly get the position of the single number , but this is not necessary as when while exits it will have position of single digit in l
            // if (mid != 0 && mid != nums.length - 1) {
            //     if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
            //         return nums[mid];
            // } else if (mid == 0 && nums[mid] != nums[mid + 1]) {
            //     return nums[mid];
            // } else if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
            //     return nums[mid];
            // }

            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid + 1]) {
                    r = mid ;
                } else {
                    l = mid+1;
                }
            } else {
                if (nums[mid] != nums[mid - 1]) {
                    r = mid ;
                } else {
                    l = mid+1;
                }
            }

        }

        return nums[l];

    }


}

package FindInRotatedSortedArray_LeetCode_33;

/*
Problem URl : https://leetcode.com/problems/search-in-rotated-sorted-array/description/

Achieved TC : OLogN

Problem Statement :
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */


/*
Soln Logic
Get the mid element and compare it with nums [l] element
if l element is smaller that means to the left of mid we have all small values
    now check if  the target lies between l element and mid element
    if it does move r to mid
    else move l to mid+1
else
    check if target lies btw mid and right element move l to mid +1
    else move r to mid

 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        // Update the testcase in next line as per requirement .
        // The next line is written only for execution purpose.
        System.out.println((search(new int[]{4,5,6, 7, 1, 2, 3}, 6)));
    }
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            return -1;
        }
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid-1;
                }
            }
        }

        return -1;
    }
}

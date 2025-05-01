package FindPeakElement_LeetCode_162;

/*

Problem URL: https://leetcode.com/problems/find-peak-element/description/

Soln TC - OLogN

Problem Statement :

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */


public class FindPeakElement {

    public static void main(String[] args) {
        // Update the testcase in next line as per requirement .
        // The next line is written only for execution purpose.
        System.out.println(findPeakElement(new int[]{1,2,3,2,1}));
    }

    // Main soln
    /*
    Soln logic :
        Check if mid has smaller neighbours
        if not then check the neighbour which is larger than mid and move your l and r to that direction
        We do this as if we look from the perspective of the neighbour it already has 1 small element as it neighbour i.e mid , so we move in this direcn
     */
    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid ;

        while (l < r) {
            mid = l + (r - l) / 2;

            // here directly returning 1 if when mid is 0 and not greater than neighbour because for mid to get 0 l has  to be 0 and r 1 onlt in that case we can get mid = 0 , thus that means only other element remaining is 1 , thus return 1
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1])
                    return 0;
                return 1;
            }
            // Same explanation as above
            if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1])
                    return 1;
                return 0;
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                if (nums[mid] < nums[mid + 1])
                    l = mid + 1;
                else
                    r = mid;
            }
        }
        return l;
    }
}


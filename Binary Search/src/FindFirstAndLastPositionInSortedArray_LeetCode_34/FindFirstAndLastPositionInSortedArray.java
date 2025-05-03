package FindFirstAndLastPositionInSortedArray_LeetCode_34;
/*
Problem URL : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Achieved TC : OlogN

Problem Statement :
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

import java.util.Arrays;

/*
Soln Explain -
    Used Binary Search to get this
    Executed Binary Search twice
    Once to get first position and next time to last position of the target

 */
public class FindFirstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        // Update the testcase in next line as per requirement .
        // The next line is written only for execution purpose.
        System.out.println(Arrays.toString(searchRange(new int[]{5, 6, 6, 7, 7, 8, 9}, 6)));
    }

    public static int[] searchRange(int[] input, int target) {

        int[] abc = new int[2];
        int l = 0;
        int r = input.length - 1;
        int mid;

        if (input.length == 0) {
            abc[0] = -1;
            abc[1] = -1;
            return abc;
        }

        while (l < r) {
            mid = l + (r - l) / 2;
            if (input[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (input[l] != target) {
            abc[0] = -1;
            abc[1] = -1;
            return abc;
        } else {
            abc[0] = l;
        }

        l = 0;
        r = input.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (input[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        abc[1] = l - 1;
        return abc;
    }
}

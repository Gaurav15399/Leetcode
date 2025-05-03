package Search2DMatrix_LeetCode_74;


/*

Problem URL : https://leetcode.com/problems/search-a-2d-matrix/description/

Achieved TC : OLog(MN)

Problem Statement :
You are given an m x n integer matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */


/*
Soln logic
We have sorted 2d array
simply first apply BS vertically , then find the row where we may find our elemnt
then again apply BS on the row and find element if present
 */
public class Search2DMatrix {
    public static void main(String[] args) {
// Update the testcase in next line as per requirement .
        // The next line is written only for execution purpose.
        System.out.println((searchMatrix(new int[][]{{1,2,3},{4,5,6}}, 5)));
    }
    public static boolean searchMatrix(int[][] nums, int target) {
        int l = 0;
        int v = nums[0].length - 1;
        int h = nums.length - 1;
        int r = -1;
        int mid;

        while (l <= h) {
            mid = l + (h - l) / 2;
            if (target >= nums[mid][0] && target <= nums[mid][v]) {
                r = mid;
                break;
            } else if (target < nums[mid][0]) {
                h = mid-1;
            } else {
                l = mid + 1;
            }
        }
        if (r == -1) {
            return false;
        }

        l = 0;
        while (l <= v) {
            mid = l + (v - l) / 2;
            if (nums[r][mid] == target)
                return true;
            if (target > nums[r][mid]) {
                l = mid + 1;
            } else {
                v = mid-1;
            }
        }
        return false;
    }
}

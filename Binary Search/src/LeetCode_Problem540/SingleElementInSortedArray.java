package LeetCode_Problem540;

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

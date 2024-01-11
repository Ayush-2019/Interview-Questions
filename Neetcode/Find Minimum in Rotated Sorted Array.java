class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int i = 0, j = n - 1;

        while (i <= j) {

            int mid = (i + j) / 2;
            
            if(mid>0 && nums[mid] < nums[mid-1]) return nums[mid];

            if(nums[j] < nums[mid]) i = mid+1;

            else j = mid-1;

            
        }

        return nums[i];

    }
}

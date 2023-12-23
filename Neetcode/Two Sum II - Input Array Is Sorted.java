class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        int i=0, j = n-1;

        int[] ans = new int[2];

        while(true){

            int first = nums[i], second = nums[j];

            if(first+second > target) j--;
            else if(first+second < target) i++;

            else{
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }
        }

        
        
    }
}

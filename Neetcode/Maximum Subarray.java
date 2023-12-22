class Solution {
    public int maxSubArray(int[] nums) {

        int ans = nums[0], temp = 0;

        for(int x: nums){

            if(temp < 0) {
                temp = 0;
                
            }

            temp += x;
            ans = Math.max(ans, temp);
            
            
             
        }

        return Math.max(ans, temp);
        
    }
}

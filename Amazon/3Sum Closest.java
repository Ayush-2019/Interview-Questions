class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i+1, k = n-1;

            while(j<k){
                if(Math.abs(ans-target) > Math.abs(nums[i]+nums[j]+nums[k]-target)){
                    ans = nums[i]+nums[j]+nums[k];
                }

                else if(nums[i]+nums[j]+nums[k] > target) k--;

                else j++;
            }
        }

        return ans;
    }
}

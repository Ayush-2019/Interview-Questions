class Solution {

    public boolean canJumpSimplified(int[] nums) {
       int reachable = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
    }
    
    public boolean canJump(int[] nums) {


        int n = nums.length;

        int[] range = new int[n];

        for(int i=0;i<n;i++){

            range[i] = nums[i] + i;
        } 

        int curr = 0, temp = Integer.MIN_VALUE;
        if(curr == n-1) return true;
        while(curr<n-1){
            int temp2 = curr;
            for(int i=curr+1;i<=temp2+nums[temp2];i++){
                if(range[i-1]>=n-1) return true;
                if(temp<=range[i]){
                    temp = Math.max(temp, range[i]);
                    curr = i;
                }

                

            }
            if(nums[curr] == 0) return false;

        }

        return true;
        
    }
}

class Solution {
    public int maxArea(int[] height) {

        int ans = 0, n = height.length;
        int l = 0, r = n-1;

        while(l<=r){
            int amount = Math.min(height[l], height[r]) * (r-l);
            ans = Math.max(ans, amount);

            if(height[l]<=height[r]) l++;
            else r--;
        }

        return ans;
    }
}

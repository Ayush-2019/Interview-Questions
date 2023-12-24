class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int left_max = height[0], right_max = height[n-1], ans = 0;
        int k = 0, j = n-1;

        while(k != n){

            left[k] = left_max;
            left_max = Math.max(left_max, height[k]);

            right[j] = right_max;
            right_max = Math.max(right_max, height[j]);

            k++;
            j--;



        }

        for(int i=0;i<n;i++){

            ans += Math.min(left[i], right[i]) - height[i] > 0 ? Math.min(left[i], right[i]) - height[i]: 0;

        }

        return ans;
        
    }
}

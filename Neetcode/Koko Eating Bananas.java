class Solution {

    public boolean checkAll(int[] piles, int h, int k){

        int total = 0;

        for(int x: piles){

            int curr = x%k == 0 ? x/k : (x/k)+1;

            total += curr;
            if(total > h) return false;
        }

        return true;


    }

    public int minEatingSpeed(int[] piles, int h) {

        int start = 0, end = Integer.MIN_VALUE;
        int ans = 0;

        for(int x: piles){
            end = Math.max(end, x);
        }

        while(start <= end){

            int mid = (start+end)/2;
            if(mid == 0) break;

            if(checkAll(piles, h, mid)){
                ans = mid;
                end = mid-1;
            }

            else start = mid+1;
        }

        return ans;
        
    }
}

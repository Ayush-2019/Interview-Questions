class Solution {
    int n;

    public int binarySearch(int[] nums, int target, int i, int j){

        if(i<=j){

            int mid = (i+j)/2;
            int val = nums[mid];

            if(val == target) return mid;

            if(val < target) return binarySearch(nums, target, mid+1, j);

            else return binarySearch(nums, target, i, mid-1);

            
        }

        return -1; 
        



    }

    public int search(int[] nums, int target) {

        n = nums.length;

        // return binarySearch(nums, target, 0, n-1);

        int i = 0, j = n-1;

        while(i<=j){

            int mid = (i+j)/2;
            int val = nums[mid];

            if(val == target) return mid;

            if(val < target) i = mid+1;

            else j = mid-1; 
        }

        return -1;
        
    }
}

class Solution {

    int n, m, total;

    public boolean binarySearch(int[][] matrix, int target, int start, int end){

        if(start <= end){

            int mid = (start+end)/2;
            int i = mid%m == 0 ? (mid/m)-1 : mid/m;
            int j = mid%m == 0 ? m-1 : mid%m - 1;

            int val = matrix[i][j];

            if(val == target) return true;

            if(val < target) return binarySearch(matrix, target, mid+1, end);

            else return binarySearch(matrix, target, start, mid-1);

            
        }

        return false; 
        



    }

    public boolean searchMatrix(int[][] matrix, int target) {

        n = matrix.length;
        m = matrix[0].length;
        total = n*m;

        return binarySearch(matrix, target, 1, total);
        
    }
}

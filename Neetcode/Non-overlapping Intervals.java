class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0, left = 0, n = intervals.length;
        for (int right=1;right<n;right++) {
            if (intervals[left][1] <= intervals[right][0]) { 
                left = right;
            } 
            else if (intervals[left][1] <= intervals[right][1]) {
                ans++;
            } 
            else if (intervals[left][1] > intervals[right][1]) { 
                ans++;
                left = right;
            }
        }
        return ans;
    }
}

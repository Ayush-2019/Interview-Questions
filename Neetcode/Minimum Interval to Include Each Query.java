class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int[] sq = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sq);
        int[] ans = new int[queries.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0, n = intervals.length;

        for(int q: sq){

            while(i<n && q>=intervals[i][0]){
                int start = intervals[i][0], end = intervals[i][1];
                pq.add(new int[]{end-start+1, end});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<q) pq.remove();
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        i = 0;
        for(int q: queries){
            ans[i++] = map.get(q);
        }

        return ans;
        
    }
}

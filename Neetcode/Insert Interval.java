class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        

        List<int[]> ans = new ArrayList<>();

        int n = intervals.length;
        int c = n+1, i = 0;
        boolean done = false;
        if(n == 0) return new int[][]{newInterval};
        else if(newInterval.length == 0) return intervals;

        while(c > 0){

            int[] curr;
            if(done){
                curr = intervals[i];
                i++;
            }
            else {
                if(i<n && intervals[i][0]<newInterval[0]){
                    // System.out.println(i);
                    curr = intervals[i];
                    i++;
                }
                else{
                    curr = newInterval;
                    done = true;
                }
            }

            if(ans.size() == 0) ans.add(curr);
            else{

                int[] prev = ans.get(ans.size()-1);
                if(prev[1] >= curr[0]){
                    prev[1] = Math.max(prev[1], curr[1]);
                    ans.set(ans.size()-1, prev);
                }
                else ans.add(curr);
                
            }


            c--;
        }

        int[][] array = new int[ans.size()][];
        for (int j = 0; j < ans.size(); j++) {
            int[] row = ans.get(j);
            array[j] = row;
        }

        return array;
        
    }
}

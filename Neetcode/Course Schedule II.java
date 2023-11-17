class Solution {

    int[] ans;
    int c;

    public boolean cyclic(ArrayList<ArrayList<Integer>> adj, int[] vis, int i){

        if(vis[i] == 2) return true;

        vis[i] = 2;

        for(int j=0;j<adj.get(i).size();j++){
            if(vis[adj.get(i).get(j)] != 1 && cyclic(adj, vis, adj.get(i).get(j))) return true;
        }
        vis[i] = 1;
        ans[c] = i;
        c++;
        return false;
    }

    public int[] findOrder(int num, int[][] pre) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ans = new int[num];
        c = 0;

        for(int i=0;i<num;i++) adj.add(new ArrayList<>());

        for(int i=0;i<pre.length;i++) adj.get(pre[i][0]).add(pre[i][1]);

        int[] vis = new int[num];

        for(int i=0;i<num;i++) if(vis[i] == 0 && cyclic(adj, vis, i)) return new int[0];

        return ans;
        
    }
}

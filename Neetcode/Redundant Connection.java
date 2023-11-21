class Solution {

    public boolean isCyclic(ArrayList<ArrayList<Integer>>adj, boolean[] vis,int  parent,int node){

        vis[node] = true;

        for(int n: adj.get(node)){

            if(vis[n] == true && n != parent ) return true;

            else if(n != parent && isCyclic(adj, vis, node, n)) return true ; 
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = Integer.MIN_VALUE;

        for(int[] edge:edges) n = Math.max(n, Math.max(edge[0], edge[1]));

        n++;

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());


        for(int[] edge: edges){

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

            boolean[] vis = new boolean[n+1];

            if(isCyclic(adj, vis, -1, edge[0])) return edge;
        }

        return new int[0];
        
    }
}

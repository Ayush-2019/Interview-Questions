class Solution {

    public double sq(int n){
        return Math.pow(n,2);
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq= new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return Double.compare(a.dist,b.dist);
            }
        });
        int[][] ans = new int[k][2];

        for(int[] point: points){

            double dist = Math.sqrt(sq(point[0])+sq(point[1]));

            pq.add(new Pair(dist, point));
        }

        for(int i = 0;i<k;i++){
            ans[i] = pq.poll().point;
        }

        return ans;
        
    }
}

class Pair{
    double dist;
    int[] point;

    Pair(double dist,int[] point){

        this.dist = dist;
        this.point = point;
    }
    
}

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] t) {

        boolean first = false, second = false, third = false;

        for(int[] x: triplets){

            if(x[0] <= t[0] && x[1] <= t[1] && x[2] <= t[2]){

                if(x[0] == t[0]) first = true;
                if(x[1] == t[1]) second = true;
                if(x[2] == t[2]) third = true;
            }
        }

        return first && second && third;
        
    }
}

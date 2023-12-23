class Solution {
    public boolean isNStraightHand(int[] hand, int size) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x:hand) pq.add(x);

        while(pq.size()!=0){

            int poll = pq.poll();

            for(int i=1;i<size;i++){

                if(!pq.remove(poll+i)) return false;
            }

        }

        return true;
        
    }
}

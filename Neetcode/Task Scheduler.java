class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){

            @Override
            public int compare(Pair a, Pair b){
                return b.count - a.count;
            }
        });

        Stack<Pair> st = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();

        for(char c: tasks) map.put(c, map.getOrDefault(c, 0)+1);

        for(Map.Entry<Character, Integer> entry: map.entrySet()) pq.add(new Pair(entry.getKey(), entry.getValue()));

        int idle = 0;

        while(!pq.isEmpty()){

            int k = n+1;

            while(k>0 && !pq.isEmpty()){

                Pair temp = pq.poll();
                temp.count--;

                if(temp.count != 0) st.add(temp);

                k--;

            }

            while(!st.isEmpty()) pq.add(st.pop());
            if(!pq.isEmpty()) idle += k;
        }

        return idle + tasks.length;
        
    }
}

class Pair{

    char ch;
    int count;

    Pair(char ch, int count){
        this.ch = ch;
        this.count = count;
    }
}

class Pair{
        int time;
        String val;

        Pair(int time, String val){
            this.time = time;
            this.val = val;
        }
    }

class TimeMap {

    Map<String,List<Pair>> map;

    public TimeMap() {

        map = new HashMap<>();
        
    }

    public int findNearest(List<Pair> list, int timestamp){

        int i = 0, j = list.size()-1;

        while(i<=j){

            int mid = i+(j-i)/2;

            if(list.get(mid).time == timestamp) return mid; //important for [10,20]

            if(list.get(mid).time < timestamp) i = mid+1;

            else  j = mid-1;
        }

        return j; //important for [10,20]


    }
    
    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)) map.put(key,  new ArrayList<>());

        map.get(key).add(new Pair(timestamp, value));

        // System.out.println(map.get(key).get(map.get(key).size()-1).val);
        
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return "";

        int idx = findNearest(map.get(key), timestamp);

        // System.out.println(idx);

        return idx != -1 ? map.get(key).get(idx).val : "";
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// Passing 266/267 cases, 1 is remaining

class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        int size = 0, checkSize = 0;

        for(char c: t.toCharArray()){

            if(!m1.containsKey(c)){
                m1.put(c,1);
                size++;
            }
            else m1.put(c, m1.get(c)+1);
        }       

        int i = 0, j = 0, ansi = 0, len = Integer.MAX_VALUE, n = s.length();
        String ans = "";

        while(j<n){

            char c = s.charAt(j);

            m2.put(c, m2.getOrDefault(c,0)+1);

            if(m1.containsKey(c) && m2.get(c) == m1.get(c)) checkSize++;

            if(size == checkSize){
                

                while(true){

                    char c2 = s.charAt(i);
                    if(m1.containsKey(c2) && m1.get(c2) == m2.get(c2)) break;

                    m2.put(c2, m2.get(c2)-1);
                    i++;
                }

            

                if(j-i < len){
                    ansi = i;
                    len = j-i+1;
                }
            }

            j++;
        }

        return len == Integer.MAX_VALUE? "" : s.substring(ansi, ansi+len);


    }
}

class Solution {
    public int lengthOfLongestSubstring(String S) {
        HashSet<Character> set = new HashSet<Character>();
        
        int ans = 0, i=0, j=0, n = S.length();
        
        while(j<n){
            char c = S.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                
                ans = Math.max(ans, j-i+1);
            }
            else{
                while(set.contains(c) == true){
                    set.remove(S.charAt(i));
                    i++;
                }
                set.add(c);
            }
            j++;
        }
        return ans;
    }
}

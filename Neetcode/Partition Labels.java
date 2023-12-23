class Solution {
    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++) map.put(s.charAt(i), i);

        List<Integer> ans = new ArrayList<>();

        int curr_limit = map.get(s.charAt(0)), c = 1;

        for(int i=1;i<s.length();i++){

            if(i<=curr_limit){
                
                curr_limit = Math.max(curr_limit, map.get(s.charAt(i)));
                c++;
            }
            else{
                curr_limit = map.get(s.charAt(i));
                ans.add(c);
                c = 1;
            }
            if(curr_limit == s.length()-1) {

                c += s.length()-1 - i;
                break;
                };

        }
        ans.add(c);
        return ans;
    }
}

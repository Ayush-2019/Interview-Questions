class Solution {

    public void solve(List<String> ans, HashMap<Character, String> map, String s, int num, String str){

        if(num == s.length()) ans.add(str);

        else{
            for(int i=0;i<map.get(s.charAt(num)).length();i++){
                solve(ans, map, s, num+1, str + map.get(s.charAt(num)).charAt(i));
            }
        }

    }

    public List<String> letterCombinations(String s) {
        
        HashMap<Character, String> map = new HashMap<Character, String>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ans = new ArrayList<>();

        if(s.equals("")) return ans;

        solve(ans, map, s, 0, "");

        return ans;
    }
}

class Solution {

    List<List<String>> ans;
    List<String> list;

    public boolean isPalin(String s){

        int i=0, j= s.length()-1;

        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public void solve(String s, int start){

        if(start == s.length()) ans.add(new ArrayList<>(list));

        for(int i=start;i<s.length();i++){

            if(isPalin(s.substring(start, i+1))){

                list.add(s.substring(start, i+1));
                solve(s, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        this.ans = new ArrayList<>();

        this.list = new ArrayList<>();

        solve(s, 0);

        return ans;
        
    }
}

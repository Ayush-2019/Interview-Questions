class Solution {
    public String convert(String s, int rows) {
        
        String ans = "";

        for(int i=0;i<1;i++){

            int jump = (rows-i-1)*2 != 0 ? (rows-i-1)*2 : (rows-1)*2;
            int curr = i;
            while(curr < s.length()){
                ans = ans + s.charAt(curr);
                curr += jump;
                if (curr>s.length())return ans;
            }
        }

        return ans;

        
    }
}

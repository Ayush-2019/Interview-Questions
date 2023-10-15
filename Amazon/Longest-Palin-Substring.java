class Solution {
    boolean isPalin(boolean dp[][], String s, int i, int j){
        if(i == j){
            return dp[i][j] = true;
        }
        else if(j-i == 1 && s.charAt(i) == s.charAt(j)){
            return dp[i][j] = true;
        }
        else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
            return dp[i][j] = true;
        } 

        return false;
        
    }
    
    public String longestPalindrome(String s){
        // code here
        int start = 0, max = 0, n = s.length();
        boolean dp[][] = new boolean[n][n];
        
        for(int i=0;i<n;i++) Arrays.fill(dp[i], false);
        
        
        for(int g=0; g<n;g++){
            
            for(int i=0, j=g; j<n;i++, j++){
                
                if(isPalin(dp, s, i, j)){
                    if(j-i+1>max){
                        start = i;
                        max = j-i+1;
                    }
                }
            }
        }
        
        return s.substring(start, start+max);
    }
}

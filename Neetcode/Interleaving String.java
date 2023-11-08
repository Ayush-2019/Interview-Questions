class Solution {


    public boolean solve(Map<String, Boolean> map, int n1, int n2, int n3, String s1, String s2, String s3, int i, int j, int k){

        String key = String.valueOf(i) + "*" + String.valueOf(j) + "*" + String.valueOf(k);

        if(k == n3 && i == n1 && j == n2) return true;
        if(k == n3 && (i < n1 || j < n2)) return false;

        if(map.containsKey(key)) return map.get(key);


        boolean one = false, two = false;
        if(i<n1 && s1.charAt(i) == s3.charAt(k)) one =  solve(map, n1, n2, n3, s1, s2, s3, i+1, j, k+1);
        if(j<n2 && s2.charAt(j) == s3.charAt(k)) two = solve(map, n1, n2, n3, s1, s2, s3, i, j+1, k+1);

        map.put(key, one || two);

        return one || two;

    
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        Map<String, Boolean> map = new HashMap<>();


        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        return solve(map, n1, n2, n3, s1, s2, s3, 0, 0, 0);
        
    }
}

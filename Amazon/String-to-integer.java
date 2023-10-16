class Solution {
    public int myAtoi(String s) {
        int n = s.length(), i=0, neg = 0, pos = 0;
        double ans = 0;

        while(i<n && s.charAt(i) == ' ') i++;

        if(i<n && s.charAt(i) == '-') {

        neg++;
        i++;
        }
        if(i<n && s.charAt(i) == '+') {
        pos++;
        i++;
        }

        while(i<n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            ans = ans*10 + s.charAt(i) - '0';
            i++;
        }
        if(neg>0 && pos>0) return 0;

        if(neg>0) ans = -1*ans;

        if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int)ans;
    }
}

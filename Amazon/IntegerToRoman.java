class Solution {
    public String intToRoman(int num) {
        String ans = "";

        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {
            "M" ,
            "CM",
            "D",
            "CD",
            "C",
            "XC",
            "L",
            "XL",
            "X",
            "IX",
            "V",
            "IV",
            "I"
        };
        int i=0;
        while(num>0){

            if(num >= value[i]){
                ans = ans + roman[i];
                num = num - value[i];
            }
            else i++;
        }

        return ans;

    }
}

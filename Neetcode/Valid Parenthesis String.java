class Solution {
    public boolean checkValidString(String s) {

        int n = s.length();
        
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i<n;i++){

            char c = s.charAt(i);

            if(c == '(') open.push(i);
            else if(c == '*') star.push(i);

            else{
                
                if(open.size()>0) open.pop();
                else{
                    if(star.size() > 0) star.pop();
                    else return false;
                }

            }


        }

        if(star.size() < open.size()) return false;

        while(open.size() > 0){

            if(star.pop() < open.pop()) return false;
        }

        return true;
        
    }
}

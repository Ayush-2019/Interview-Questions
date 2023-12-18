public class Main {
    
    public static String alignLine(String[] aligns, String temp, int i, int width){
        
        if(temp.length()<width){
            
            if(aligns[i].equals("LEFT")){
                return '*' + temp + " ".repeat(width-temp.length()) + '*';
            }
            else{
                return '*' + " ".repeat(width-temp.length()) + temp + '*';
            }
        }
        
        return '*' + temp + '*';
        
    }
    
    public static String[] solution(String[][] par, String[] aligns, int width){
        
        ArrayList<String> ans = new ArrayList<>();
        
        ans.add("*".repeat(width+2));
        
        for(int i=0;i<par.length;i++){
            
            String temp = "";
            
            for(String str: par[i]){
                
                if(temp.length() == 0) temp += str;
                
                else{
                    
                    if((temp.length()+str.length()+1)<=width) temp += " " + str;
                    
                    else{
                        ans.add(alignLine(aligns, temp, i, width));
                        temp = "";
                        temp += " " + str;
                    }
                }
            }
            ans.add(alignLine(aligns, temp, i, width));
        }
        ans.add("*".repeat(width+2));
        
        String[] ans2 = new String[ans.size()];
        
        for(int i=0;i<ans.size();i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
    
    public static void main(String[] args) {
        
        String[][] par = {{"hello","world"},{"How","areYou","doing"},{"Please look","and align","to right"}};
        String[] aligns = {"LEFT","RIGHT","RIGHT"};
        int width = 16;
        
        System.out.println(Arrays.toString(solution(par, aligns, width)));
    }
}

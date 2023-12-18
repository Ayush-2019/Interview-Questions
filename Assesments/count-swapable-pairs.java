public class Main {
    
    public static int compareSwaps(String a, String b){
        if(a.length() != b.length()) return 3;
        int c = 0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) c++;
        }
        
        return c;
    }
    
    public static int solution(int[] nums){
        
        int n = nums.length, ans = 0;
        Map<Integer, String> map = new HashMap<>();
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                
                
                
                if(map.containsKey(i) && map.containsKey(j) && map.get(i).equals(map.get(j)) && compareSwaps(String.valueOf(nums[i]), String.valueOf(nums[j])) <=2) ans ++;
                
                else if(map.containsKey(j)){
                    String str = String.valueOf(nums[i]);
                    char[] arr = str.toCharArray();
                    Arrays.sort(arr);
                    map.put(i, String.valueOf(new String(arr)));
                   if(map.get(i).equals(map.get(j)) && compareSwaps(String.valueOf(nums[i]), String.valueOf(nums[j]))<=2) ans ++;
                    
                }
                else if(map.containsKey(i)){
                    String str = String.valueOf(nums[j]);
                    char[] arr = str.toCharArray();
                    Arrays.sort(arr);
                    map.put(j, String.valueOf(new String(arr)));
                   if(map.get(j).equals(map.get(i)) && compareSwaps(String.valueOf(nums[j]), String.valueOf(nums[i]))<=2) ans ++;
                    
                }
                
                else{
                    String str = String.valueOf(nums[j]);
                    char[] arr = str.toCharArray();
                    Arrays.sort(arr);
                    map.put(j, String.valueOf(new String(arr)));
                    
                    String str2 = String.valueOf(nums[i]);
                    char[] arr2 = str.toCharArray();
                    Arrays.sort(arr2);
                    map.put(i, String.valueOf(new String(arr2)));
                    
                    if(map.get(i).equals(map.get(j)) && compareSwaps(String.valueOf(nums[i]), String.valueOf(nums[j]))<=2) ans ++;
                }
                
            }
        }
        
        return ans;
    }
    
    
    public static void main(String[] args) {
        
        int[] nums = {123,321,123};
        
        System.out.println(solution(nums));
    }
}

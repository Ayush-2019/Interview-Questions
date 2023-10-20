import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);
         List<List<Integer>> q=new ArrayList<>();
         int n=nums.length;
         for(int i=0;i<n-3;i++)
         {
             if(i>0&&nums[i]==nums[i-1])
             {
                 continue;
             }
             for(int j=i+1;j<n;j++)
             {
                 if(j>i+1&&nums[j]==nums[j-1])
                 {
                     continue;
                 }
                 int k=j+1;
                 int l=n-1;
                 while(k<l)
                 {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(target==sum)
                    {
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        q.add(list);
                        k++;
                        l--;

                    
                    while(k<l&&nums[l]==nums[l+1])
                    {
                        l--;
                    }
                    while(k<l&&nums[k]==nums[k-1])
                    {
                        k++;
                    }
                    }
                    else if(sum<target)
                    {
                        k++;
                    }
                    else
                    {
                        l--;
                    }
                 }
             }
         }

         return q;
           
        }
      
       
    
}

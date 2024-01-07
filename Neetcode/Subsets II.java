class Solution {

    public void solve(List<List<Integer>> ans, List<Integer> list, int[] nums, int index){

        if(index == nums.length){
            if(!ans.contains(list))ans.add(new ArrayList<>(list));
            return;
        }
        solve(ans, list, nums, index+1);

        list.add(nums[index]);
        solve(ans, list, nums, index+1);

        list.remove(list.size()-1);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        solve(ans, list, nums, 0);

        return ans;
        
    }
}

class Solution {

    public void solve(List<List<Integer>> ans, List<Integer> list, int[] nums, int index, int sum, int target){

        if(index == nums.length) return;

        if(sum > target) return;

        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        solve(ans, list, nums, index+1, sum, target);

        list.add(nums[index]);
        solve(ans, list, nums, index, sum+nums[index], target);

        list.remove(list.size()-1);

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        solve(ans, list, nums, 0, 0, target);

        return ans;
        
    }
}

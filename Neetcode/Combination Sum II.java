class Solution {

    public void solve(List<List<Integer>> ans, int[] candidates, int target, int i, int sum, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
		else if (sum > target) {
            return; 
        }

        for(int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j-1] == candidates[j]) continue;
            list.add(candidates[j]);

            solve(ans, candidates, target, j + 1, sum + candidates[j], list);

            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        solve(ans, candidates, target, 0, 0, new ArrayList<Integer>());

        return ans;
    }
    
}

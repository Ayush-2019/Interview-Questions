class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for(int i=0;i<k;i++){

            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.addLast(i);
        }

        ans.add(nums[q.peekFirst()]);

        for(int i=k;i<n;i++){

            if(i-k == q.peekFirst()) q.pollFirst();

            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]) q.pollLast();
            q.addLast(i);

            ans.add(nums[q.peekFirst()]);

        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}

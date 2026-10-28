class Solution {
    static void backtrack(int[] nums,int start,List<Integer> output, List<List<Integer>> ans){
        ans.add(new ArrayList<>(output));
        for(int i= start; i < nums.length; i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            output.add(nums[i]);
            backtrack(nums, i + 1, output, ans);
            output.remove(output.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, output, ans);
        return ans;
    }
}
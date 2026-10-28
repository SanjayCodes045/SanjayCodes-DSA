class Solution {
    public static void backtrack(int[] nums, int start,
                          List<Integer> temp,
                          List<List<Integer>> ans) {

        // Store current subset
        ans.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            temp.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, temp, ans);

            // Undo (Backtracking)
            temp.remove(temp.size() - 1);
        }
    }
    // static void backtrack(int[] nums,int start,List<Integer> output, List<List<Integer>> ans){
    //     ans.add(output);
    //     for(int i= start; i < nums.length; i++){
    //         if(i>start && nums[i] == nums[i-1]){
    //             continue;
    //         }
    //         output.add(nums[i]);
    //         backtrack(nums, i + 1, output, ans);
    //         output.remove(output.size() - 1);
    //     }
    // }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> output = new ArrayList<>();
        // Arrays.sort(nums);
        // backtrack(nums, 0, output, ans);
        // return ans;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
}
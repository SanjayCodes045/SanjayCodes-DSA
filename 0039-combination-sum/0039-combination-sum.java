class Solution {
    static void solve(int[] candidates, int target, List<List<Integer>> ans,List<Integer> output,int i){
        if(i>=candidates.length) return;
        if(target < 0) return;
        if(target == 0){
           ans.add(new ArrayList<>(output));
            return; 
        }
        output.add(candidates[i]);
        solve(candidates,target-candidates[i],ans,output,i);

        output.remove(output.size()-1);
        solve(candidates,target,ans,output,i+1);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(candidates,target,ans,output,0);
        return ans;
    }
}
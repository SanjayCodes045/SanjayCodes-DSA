class Solution {
    static void solve(int[] candidates, int target, List<List<Integer>> ans,List<Integer> output,int i,int k, int count){
        if(target < 0) return;
        if(count == k && target == 0){
           ans.add(new ArrayList<>(output));
            return; 
        }
        if(i>=candidates.length) return;
        if(count > k) return;
        output.add(candidates[i]);
        solve(candidates,target-candidates[i],ans,output,i+1,k,count+1);

        output.remove(output.size()-1);
        // while(i+1 < candidates.length && candidates[i] == candidates[i+1]){
        //     i++;
        // }
        solve(candidates,target,ans,output,i+1,k,count);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        int i = 0;
        int target = n;
        int count = 0;
        solve(candidates,target,ans,output,i,k,count);
        return ans; 
    }
}
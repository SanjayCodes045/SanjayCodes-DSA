class Solution {
    static int solve(int[] nums, int s, int e, int target){
        if(s>e) return -1;
        int mid = s + (e-s)/2;
        if(target == nums[mid]) return mid;
        if(target > nums[mid]){
            s = mid+1;
        }else if(target < nums[mid]){
            e = mid-1;
        }
        return solve(nums, s,e,target);
    }
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        return solve(nums,s,e,target);
    }
}
class Solution {
    static void solve(String digits,String[] mapping, List<String> ans,StringBuilder output,int index){
        if(index>=digits.length()){
            ans.add(output.toString());
            return;
        }

        int value = digits.charAt(index) - '0';
        String mappedString = mapping[value];

        for(int i = 0; i < mappedString.length(); i++){
            output.append(mappedString.charAt(i));
            solve(digits,mapping,ans,output,index+1);
            //backtracking step
            output.deleteCharAt(output.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        solve(digits,mapping,ans,output,0);
        return ans;
    }
}
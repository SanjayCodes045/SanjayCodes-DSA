class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            int j = i;
            while(j<s.length() && s.charAt(j) !=' '){
                j++;
            }
            int k = j-1;
            while(k>=i){
                ans.append(s.charAt(k));
                k--;
            }
            if(j<s.length()){
                ans.append(' ');
            }
            i = j+1;

        }
        return ans.toString();
    }
}
class Solution {
    static boolean compareFreq(int[] freq1,int[] freq2){
        for(int i = 0; i<26; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;

        int[] freq1 = new int[26];
        for(int i = 0; i < n; i++){
            char ch = s1.charAt(i);
            int index = ch - 'a';
            freq1[index]++;
        }
        int i = 0;
        int[] freq2 = new int[26];
        for(i = 0; i < n; i++){
            char ch = s2.charAt(i);
            int index = ch - 'a';
            freq2[index]++;
        }

        if(compareFreq(freq1, freq2) == true){
            return true;
        }else{
            while(i < m){
                char newChar = s2.charAt(i);
                int newCharIndex = newChar - 'a';
                freq2[newCharIndex]++;

                int oldCharIndex = i - n;
                char oldChar = s2.charAt(oldCharIndex);
                int freqTableIndexOfOldChar = oldChar - 'a';
                freq2[freqTableIndexOfOldChar]--;
                if(compareFreq(freq1, freq2) == true)
                    return true;
                i++;
            }
        }
        return false;
    }
}
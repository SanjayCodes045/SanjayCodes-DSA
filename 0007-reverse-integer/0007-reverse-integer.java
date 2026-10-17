class Solution {
    public int reverse(int x) {
        
        int reverseNo = 0;
        while(x != 0){
            int digit = x%10;
            if (reverseNo > Integer.MAX_VALUE / 10 ||
                (reverseNo == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (reverseNo < Integer.MIN_VALUE / 10 ||
                (reverseNo == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            reverseNo = reverseNo * 10 + digit;
            x /= 10;
        }
        
        return reverseNo;
    }
}
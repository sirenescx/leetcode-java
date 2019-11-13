/* Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward. */

class Solution {
    
    // full reverse
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        
        int fx = x;
        int rx = 0;
        while (x > 0) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        
        return rx == fx;
    }
    
    // half reverse
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int rx = 0;
        while (x > rx) {
            rx = rx * 10 + x % 10;
            x /= 10;
        }
        
        return x == rx || x == rx / 10;
    }
}
/* Given an integer, write a function to determine if it is a power of two.*/

class Solution {
    
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        
        String s = Integer.toBinaryString(n);
        if (s.charAt(0) != '1') {
            return false;
        }
        
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isPowerOfTwo2(int n) {
        return (n > 0 && ((n & (n - 1)) == 0));
    }
    
    public boolean isPowerOfTwo3(int n) {
        long x = 1;

        while (x < n) {
            x *= 2;
        }
        
        return x == n;
    }
}

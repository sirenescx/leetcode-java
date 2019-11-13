/* Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.*/

class Solution {
    public boolean hasAlternatingBits1(int n) {
        int x = n & 1;
        n >>>= 1;
        int counter = 0;
        while (n != 0) {
            int temp = n & 1;
            if (temp == x) {
                return false;
            }
            x = temp;
            n >>>= 1;  
        }
        return true;
    }
    
    public boolean hasAlternatingBits2(int n) {
        String bits = Integer.toBinaryString(n);
        for (int i = 0; i < bits.length() - 1; i++) {
            if (bits.charAt(i) == bits.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasAlternatingBits3(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }
    
    public boolean hasAlternatingBits4(int n) {
        return (((long)n + (n >> 1) + 1) & ((long)n + (n >> 1) )) == 0;
    }
    
    public boolean hasAlternatingBits5(int n) {
        for (int prev = 1 - (n % 2); n > 0; prev = n % 2, n /= 2)
            if (n % 2 == prev) return false;
        return true;
    }

}
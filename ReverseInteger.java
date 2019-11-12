/* Given a 32-bit signed integer, reverse digits of an integer.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows. */

class Solution {

	public int reverse(int x) {
       int rx = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            if (rx > Integer.MAX_VALUE / 10 || rx == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            
            if (rx < Integer.MIN_VALUE / 10 || rx == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }
            
            rx = rx * 10 + pop;
        }
        return rx;
    }
    
}
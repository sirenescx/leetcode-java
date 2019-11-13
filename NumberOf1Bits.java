/* Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).*/

class Solution {
	public int hammingWeight1(int n) {
       int counter = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                ++counter;
            }
            n >>>= 1;
        }
        return counter; 
    }

    public int hammingWeight2(int n) {
        String s = Integer.toBinaryString(n);
        while (s.length() != 32) {
            s = "0" + s;
        }
        int counter = 0;
        for (int i = 0; i < 32; ++i) {
            if (s.charAt(i) == '1') {
                ++counter;
            }
        }
        return counter;
    }
}
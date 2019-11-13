/*Reverse bits of a given 32 bits unsigned integer.*/

class Solution {
	public int reverseBits1(int n) {
		int rn = 0;
		
		for (int i = 0; i < 32; i++) {
			rn <<= 1;
			rn += n & 1;
			n >>>= 1;
		}
		return rn;
    } 
    
    public int reverseBits2(int n) {
        String s = Integer.toBinaryString(n);
        while (s.length() < 32) {
            s = "0" + s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        s = sb.reverse().toString();
        return (int)Long.parseLong(s, 2);
    }
}
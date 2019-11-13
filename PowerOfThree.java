class Solution {
	
    public boolean isPowerOfThree1(int n) {
        long x = 1;
        
        while (x < n) {
            x *= 3;
        }
        
        return x == n;
    }
    
    // without loop or recursion, but very slow
    public boolean isPowerOfThree2(int n) {
        String s = Integer.toString(n, 3);
        String firstToEnd = s.substring(1);
        return (n > 0 && s.charAt(0) == '1' && !firstToEnd.contains("1") && !firstToEnd.contains("2"));
    }
    
    // without loop or recursion using regular expressions, but also slow
    public boolean isPowerOfThree3(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
    
    // n = 3^i
    // i = log_3(n)
    // i = log_b(n) / log_b(3), supposing b is 10
    public boolean isPowerOfThree4(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree5(int n) {
        int maxPowerOfThreeIntValue = (int) Math.pow(3, (int) (Math.log10(Integer.MAX_VALUE) / Math.log10(3)));
        return n > 0 && maxPowerOfThreeIntValue % n == 0;
    }
    
}
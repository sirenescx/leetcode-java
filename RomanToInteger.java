class Solution {
    
    public int convertSymbolToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
    
    public int romanToInt(String s) {
        int result = 0;
        int current = 0;
        int previous = -1;
        
        for (int i = 0; i < s.length(); ++i) {  
            current = convertSymbolToInt(s.charAt(i));
            
            if ((previous == 1 && current == 5) || (previous == 1 && current == 10)) {
                result -= 2;
            } else 
            if ((previous == 10 && current == 50) || (previous == 10 && current == 100)) {
                result -= 20;
            } else 
            if ((previous == 100 && current == 500) || (previous == 100 && current == 1000)) {
                result -= 200;
            } 
            
            result += current;
            previous = current;
        }
        
        return result;
    }
}
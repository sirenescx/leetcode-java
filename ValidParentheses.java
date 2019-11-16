/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid. */

class Solution {
    
    boolean checkIfSame(char current, char previous) {
        if (current == ')' && previous == '(') {
                return true;
        }
        
        if (current == '}' && previous == '{') {
                return true;
        }
        
        if (current == ']' && previous == '[') {
                return true;
        }
        
        return false;
    }
    
    public boolean isValid1(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char bracket = s.charAt(i);    
            if (!stack.empty() && checkIfSame(bracket, stack.peek())) {
                    stack.pop();
            } else {
                stack.push(bracket);
            }
        }
        return stack.empty();
    }
    
    private HashMap<Character, Character> pairBrackets;
        
    public Solution() {
        pairBrackets = new HashMap<>();
        pairBrackets.put(')', '(');
        pairBrackets.put('}', '{');
        pairBrackets.put(']', '[');
    }
        
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char bracket = s.charAt(i);
            if (pairBrackets.containsKey(bracket)) {
                char previousBracket = stack.empty() ? '#' : stack.pop();
                if (previousBracket != pairBrackets.get(bracket)) {
                    return false;
                }
            } else {
                stack.push(bracket);
            }   
        }
        return stack.empty();
    }
}
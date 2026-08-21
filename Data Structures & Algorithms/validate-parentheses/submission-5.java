class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        
        for(int i = 0; i < s.length(); i++){
            char paren = s.charAt(i);

            if(paren == '(' || paren == '[' || paren == '{'){
                stack.push(paren);
            }
            if(bracketMap.containsKey(paren)){
                if(!stack.isEmpty() && stack.peek() == bracketMap.get(paren)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            // if (paren == ')' || paren == ']' || paren == '}'){
            //     if(stack.isEmpty()){
            //         return false;
            //     }
            //     char topVal = stack.pop();
            //     if(paren == ')' && topVal != '('){
            //         return false;
            //     }
            //     if(paren == ']' && topVal != '['){
            //         return false;
            //     }
            //     if(paren == '}' && topVal != '{'){
            //         return false;
            //     }
            // }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}

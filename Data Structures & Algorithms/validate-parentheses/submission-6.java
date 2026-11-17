class Solution {
    public boolean isValid(String s) {
        Stack<Character> currOpenParens = new Stack<>();

        for(Character charac: s.toCharArray()){
            switch(charac){
                case '(', '[', '{' ->
                    currOpenParens.push(charac);
                
                case ')', ']', '}' -> {

                    if(currOpenParens.isEmpty()){
                        return false;
                    }
                    Character possiblePair = currOpenParens.pop();
                    if(possiblePair != '(' && charac == ')'){
                        return false;
                    }
                    if(possiblePair != '{' && charac == '}'){
                        return false;
                    }
                    if(possiblePair != '[' && charac == ']'){
                        return false;
                    }
                }

            }
        }


        return currOpenParens.isEmpty();
    }
}
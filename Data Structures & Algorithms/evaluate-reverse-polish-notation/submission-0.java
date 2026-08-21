class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");

        for(int i = 0; i < tokens.length; i++){
            if(operators.contains(tokens[i])){
                int secondNumber = Integer.parseInt(stack.pop());
                int firstNumber = Integer.parseInt(stack.pop());

                if(tokens[i].equals("+")){
                    stack.push(secondNumber + firstNumber + "");
                }
                else if(tokens[i].equals("-")){
                    stack.push(firstNumber - secondNumber + "");
                }
                else if(tokens[i].equals("*")){
                    stack.push(firstNumber * secondNumber + "");
                }
                else{
                    stack.push(firstNumber / secondNumber + "");
                }
            }
            else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

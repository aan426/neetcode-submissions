class GenerateParen{
    //most everything should be private unless another class needs that variable / method --> usually make a public method to expose that private variable ==> encapsulation (exposing only what needs to be exposed) ex: don't make fields public because that implies anyone can change it
    private List<String> listOfOutput;
    public GenerateParen(){
        listOfOutput = new ArrayList<>();
    }

    public void backTracking(int n, int openCount, int closedCount, String substring){
        //base case
        if(substringCompleted(closedCount, n)){
            listOfOutput.add(substring);
        }

        //Case 1
        if(canRecurseOpen(openCount, n)){
            //do recursion
            backTracking(n, openCount + 1, closedCount, substring + "(");
        }

        //Case 2
        if(canRecurseClosed(closedCount, openCount)){
            //do recursion
            backTracking(n, openCount, closedCount + 1, substring + ")");
        }
    }

    //returns true if more open paren remaining
    //start with empty, fill in if actually necessary
    private boolean canRecurseOpen(int openCount, int n){
        return openCount < n ? true : false;
        // if(openCount < n){
        //     return true;
        // }
        // return false;
    }

    //returns true if we can add a ')' parenthesis
    private boolean canRecurseClosed(int closedCount, int openCount){
        //if closedCount < openCount and openCount >= 1
        return closedCount < openCount && openCount >= 1 ? true : false;
    }

    //returns true if substring is properly formed
    private boolean substringCompleted(int closedCount, int n){
        return closedCount == n ? true : false;
    }

    public List<String> returnListOfOutput(){ 
        return listOfOutput;
    }
}

class Solution {
    //don't make global variables --> make a class
    public List<String> generateParenthesis(int n) {
        GenerateParen genParen = new GenerateParen();
        genParen.backTracking(n, 0, 0, "");
        return genParen.returnListOfOutput();
    }

    
}

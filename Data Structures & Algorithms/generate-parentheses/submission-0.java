class Solution {
    public List<String> generateParenthesis(int n) {
        //how many permutations of n * "(" are there -->base case is to close the current one
        List<String> ret = new ArrayList<>();
        backTracking(0, 0, n, ret, "");
        return ret;
    }

    public void backTracking(int open, int closed, int n, List<String> ret, String str){
        if(closed == n){
            ret.add(str);
            return;
        }

        //at any given point, we want to check if open paren or closed paren or both can be added to the str

        if(open < n){
            str = str + "(";
            open++; //if I put this here I have to take it back ltr
            backTracking(open, closed, n, ret, str);
            open--; //we don't want the current action to affect the closed action, that should be determined by the starting conditions of that recursion iteration
            str = str.substring(0, str.length()-1);
        }

        if(closed < open){
            str = str + ")";
            closed++;
            backTracking(open, closed, n, ret, str);
        }
    }
}

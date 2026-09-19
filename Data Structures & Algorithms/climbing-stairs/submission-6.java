class Solution {
    public int climbStairs(int n) {
        //base case
        if(n <= 1){
            return n;
        }

        int first = 1;
        int second = 1;

        for(int i = 2; i <= n; i++){
            int temp = first;
            first = first + second;
            second = temp;
        }

        return first;
    }
}

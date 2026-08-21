class Solution {
    public int maxArea(int[] heights) {
        //brute force O(n^2) check each combination
        //track max value

        //stack of monotinic increasing values holding the indicies --> doesn't work because the bars don't limit other groups, so a greater value can be found again
        //gotta use two pointers

        int i = 0;
        int j = heights.length - 1;
        int areaMax = 0;
        while(i<j){
            if(heights[i] < heights[j]){
                int newArea = heights[i] * (j-i);
                areaMax = Math.max(areaMax, newArea);
                i++;
            }
            else{ // heights[j]<=heights[i] same value doesn't affect which you do
                int newArea = heights[j] * (j-i);
                areaMax = Math.max(areaMax, newArea);
                j--;
            }
        }
        return areaMax;
    }
}

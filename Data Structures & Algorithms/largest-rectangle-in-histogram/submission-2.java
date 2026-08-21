class Solution {
    public int largestRectangleArea(int[] heights) {
        //store the largest rectangles made at each point, start a new one when there's a bigger rectangle, top element in stack should be the largest
        Stack<Integer> minMonotonic = new Stack<>();
        int max = 0;
        int i = 0;
        for(i = 0; i < heights.length; i++){
            if(minMonotonic.isEmpty()){
                minMonotonic.push(i);
            }
            else{
                int lastStart = i;
                while(!minMonotonic.isEmpty() && heights[i] < heights[minMonotonic.peek()]){
                    int index = minMonotonic.pop();
                    int area = (i - index) * heights[index];
                    max = Math.max(max, area);
                    lastStart = index;
                }
                if(!minMonotonic.isEmpty() && heights[i] == heights[minMonotonic.peek()]){
                    continue;
                }
                else{
                    heights[lastStart] = heights[i];
                    minMonotonic.push(lastStart);
                }
            }
        }

        while(!minMonotonic.isEmpty()){
            int remainingIndex = minMonotonic.pop();
            int area = (i - remainingIndex) * heights[remainingIndex];
            max = Math.max(max, area);
        }

        return max;
    }
}
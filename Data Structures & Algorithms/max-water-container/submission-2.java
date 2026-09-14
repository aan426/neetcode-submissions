class Container{
    int maxContainerSize;
    public Container(){
        maxContainerSize = 0;
    }

    public int findMaxContainer(int[] height){
        int lower = 0;
        int upper = height.length - 1;
        while(lower < upper){
            if(valAtLowerLessThanUpper(lower, upper, height)){
                maxContainerSize = Math.max(maxContainerSize, (upper - lower) * height[lower]);
                lower++;
            }
            else{
                maxContainerSize = Math.max(maxContainerSize, (upper - lower) * height[upper]);
                upper--;
            }
        }
        return maxContainerSize;
    }

    private boolean valAtLowerLessThanUpper(int lower, int upper, int[] height){
        return height[lower] <= height[upper] ? true : false;
    }
}

class Solution {
    public int maxArea(int[] height) {
        Container area = new Container();
        return area.findMaxContainer(height);
    }
}
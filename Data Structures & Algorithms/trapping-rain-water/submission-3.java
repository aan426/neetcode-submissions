class Solution {
    public int trap(int[] height) {
        //stack??

        //two pointer

        int i = 0;
        int j = height.length - 1;
        int leftMaxH = height[i];
        int rightMaxH = height[j];

        // int midArea = 0;
        int totalArea = 0;
        while(i < j){
            if(height[i] < height[j]){
                i++;
                leftMaxH = Math.max(leftMaxH, height[i]);
                
                // int areaI = Math.min(leftMaxH, rightMaxH) - height[i];
                int areaI = leftMaxH - height[i];
                // System.out.println(areaI);
                if(areaI > 0){
                    totalArea += areaI;
                }
            }
            else{
                j--;

                rightMaxH = Math.max(rightMaxH, height[j]);

                int areaJ = rightMaxH - height[j];
                // System.out.println(areaJ);

                if(areaJ > 0){
                    totalArea += areaJ;
                }

            }

        }
        return totalArea;
    }
}

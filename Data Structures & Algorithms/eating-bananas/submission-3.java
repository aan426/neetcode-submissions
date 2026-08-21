class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for(int i = 0; i < piles.length; i++){
            maxBananas = Math.max(maxBananas, piles[i]);
        }

        int lower = 1;
        int upper = maxBananas;
        int minRate = maxBananas;
        while(lower <= upper){
            int median = (upper + lower) / 2;
            int count = 0;
            int index = 0;

            while (count <= h && index < piles.length){
                if(piles[index] % median !=0){
                    count++;
                }
                count += piles[index] / median;
                index++;
                // System.out.println(count + " " + median);
            }
            if(index == piles.length && count <= h){
                minRate = median;
                upper = median -1;
            }
            else{
                lower = median +1;
            }
        }

        return minRate;
    }
}

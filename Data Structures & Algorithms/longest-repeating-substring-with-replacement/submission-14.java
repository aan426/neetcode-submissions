class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0){
            return 0;
        }

        Map<Character,Integer> lettFreqs = new HashMap<>();
        int lower = 0;
        int upper = 1;

        int maxStringLen = 1;
        int mostFreqLen = 1;
        lettFreqs.put(s.charAt(lower), 1);

        while(lower < upper && upper < s.length()){
            int subStrLen = upper - lower + 1;

            int currEleFreq = lettFreqs.getOrDefault(s.charAt(upper), 0);
            lettFreqs.put(s.charAt(upper), currEleFreq + 1);
            
            currEleFreq = lettFreqs.get(s.charAt(upper));

            mostFreqLen = Math.max(mostFreqLen, currEleFreq);
            // System.out.println(mostFreqLen + " here");
            if(subStrLen - mostFreqLen > k){
                int newEleFreq = lettFreqs.get(s.charAt(lower));
                lettFreqs.put(s.charAt(lower), newEleFreq - 1);
                // System.out.println(mostFreqLen + " ?");

                lower++;
            }
            else{ //valid substring
                maxStringLen = Math.max(maxStringLen, upper - lower + 1);
            }
            upper++;
        }
        return maxStringLen;
    }

    // public void findMostFreqElement(){

    // } 
}

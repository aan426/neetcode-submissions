class Solution {
    public String minWindow(String s, String t) {
        //set to know if element in already exists in substring
        //look for each starting window
        if(s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> tSet = new HashMap<>();
        Map<Character, Integer> windowSet = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            tSet.put(t.charAt(i), tSet.getOrDefault(t.charAt(i), 0) + 1);
        }

        int lower = 0;
        int aquired = 0;
        int target = tSet.size();
        String minSubStr = "";
        int minSubStrLen = s.length();
        int[] boundIndicies = new int[2];


        for(int upper = 0; upper < s.length(); upper++){
            char currEle = s.charAt(upper);
            windowSet.put(currEle, windowSet.getOrDefault(currEle, 0) + 1);

            if(windowSet.get(currEle).intValue() == tSet.getOrDefault(currEle, -1).intValue()){
                aquired++;
            }

            while(aquired == target && lower <= upper){
                int currLen = upper - lower + 1;
                if(currLen <= minSubStrLen){
                    boundIndicies[0] = lower;
                    boundIndicies[1] = upper + 1;
                    minSubStrLen = currLen;
                }
                char currLowerEle = s.charAt(lower);
                if(windowSet.containsKey(currLowerEle)){
                    int currLowerEleFreq = windowSet.get(currLowerEle);
                    if(currLowerEleFreq <= 0){
                        windowSet.remove(currLowerEle);
                    }
                    else{
                        windowSet.put(currLowerEle, currLowerEleFreq - 1);
                        if(tSet.containsKey(currLowerEle) && currLowerEleFreq -1 < tSet.get(currLowerEle)){
                            aquired--;
                        }
                    }
                   
                }
                lower++;
            }
        }
        minSubStr = s.substring(boundIndicies[0], boundIndicies[1]);
        return minSubStr;
    }
}

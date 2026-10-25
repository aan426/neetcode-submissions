class LongestSubstring{
    String str;
    int lowerIndex;
    int upperIndex;
    int maxLen;
    Set<Character> charSet;
    public LongestSubstring(String s){
        str = s;
        lowerIndex = 0;
        upperIndex = 1;
        maxLen = 1;
        charSet = new HashSet<>();
    }

    public int calcLongestSubstring(){
        int currLen = 1;
        charSet.add(str.charAt(lowerIndex));
        while(canContinueSearch()){
            char currChar = str.charAt(upperIndex);
            if(currCharExistsInSet(currChar)){
                while(currCharExistsInSet(currChar)){
                    charSet.remove(str.charAt(lowerIndex));
                    lowerIndex++;
                    currLen--;
                }
            }
            
            charSet.add(currChar);
            currLen++;
            maxLen = Math.max(maxLen, currLen);
            // System.out.print(currChar);
            // System.out.print(currLen);
            // System.out.println(maxLen);
            upperIndex++;
        }
        return maxLen;
    }

    private boolean canContinueSearch(){
        return upperIndex < str.length() ? true : false;
    }

    private boolean currCharExistsInSet(char currChar){
        return charSet.contains(currChar) ? true : false;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }

        LongestSubstring object = new LongestSubstring(s);
        return object.calcLongestSubstring();
    }
}

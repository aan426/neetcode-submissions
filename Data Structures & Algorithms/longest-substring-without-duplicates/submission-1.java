class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        int lower = 0;
        int upper = 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(lower));
        int maxLen = 1;

        while(lower < upper && upper < s.length()){
            while(set.contains(s.charAt(upper))){
                set.remove(s.charAt(lower));
                lower++;
            }
            set.add(s.charAt(upper));
            upper++;
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}

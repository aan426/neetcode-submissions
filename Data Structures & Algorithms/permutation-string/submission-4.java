class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //hashmap of count for smaller string, loop through larger string to decrement hashmap
        
        Map<Character,Integer> smallStr = new HashMap<>();
        Map<Character,Integer> smallStrCopy = new HashMap<>();

        if(s1.length() > s2.length()){
            return false;
        }
        for(int i = 0; i < s1.length(); i++){
            int freq = smallStr.getOrDefault(s1.charAt(i), 0) + 1;
            smallStr.put(s1.charAt(i), freq);
        }
        smallStrCopy.putAll(smallStr);

        // int lower = 0;
        int upper = 0;
        for(int i = 0; i < s2.length(); i++){
            upper = i;
            System.out.println((upper - i + 1) + " hi");

            while(upper < s2.length() && smallStr.containsKey(s2.charAt(upper)) && (upper - i + 1) <= s1.length()){
                System.out.println("here");
                int freq = smallStr.get(s2.charAt(upper)) - 1;
                if(freq == 0){
                    smallStr.remove(s2.charAt(upper));
                }
                else{
                    smallStr.put(s2.charAt(upper), freq);
                }
                upper++;
            }
            if(smallStr.size() != 0){
                smallStr.putAll(smallStrCopy);
            }
            // i = upper;
        }

        System.out.println(smallStr.entrySet());
        
        if(smallStr.size() == 0){
            return true;
        }
        return false;
    }
}

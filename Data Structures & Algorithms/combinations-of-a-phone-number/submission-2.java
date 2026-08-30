class Solution {
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        map  = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ret = new ArrayList<>();
        backTrack(digits, 0, ret, "");
        return ret;
    }

    public void backTrack(String digits, int digitPt, List<String> ret, String sublist){
        if(digitPt ==  digits.length()){
            ret.add(sublist);
            return;
        }
        // for(int i = 0; i < digits.length(); i++){
        for(int j = 0; j < map.get(digits.charAt(digitPt)).length(); j++){
            sublist = sublist + map.get(digits.charAt(digitPt)).charAt(j); 
            backTrack(digits, digitPt + 1, ret, sublist);
            sublist = sublist.substring(0, sublist.length()-1);
        }
        // }
    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        backTracking(s, 0, new ArrayList<>(), ret);
        return ret;
    }

    public void backTracking(String s, int sPt, List<String> substring, List<List<String>> ret){
        if(sPt >= s.length()){
            ret.add(new ArrayList<>(substring));
            return;
        }

        for(int j = sPt; j < s.length(); j++){
            if(isPalendrome(s, sPt, j)){
                substring.add(s.substring(sPt, j + 1));
                backTracking(s, j + 1, substring, ret);
                substring.remove(substring.size() - 1);
            }
        }
        

    }

    public boolean isPalendrome(String s, int i, int j){
        int upper = j;
        int lower = i;
        while(lower <= upper){
            if(s.charAt(lower) != s.charAt(upper)){
                return false;
            }
            upper--;
            lower++;
        }

        return true;
    }
}

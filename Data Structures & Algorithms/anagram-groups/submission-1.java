class GroupAnagrams{
    String[] strs;
    Map<String, List<String>> anagramMap;
    public GroupAnagrams(String[] strs){
        this.strs = strs;
        anagramMap = new HashMap<>();
    }

    public void sortStrings(){
        for(String string : strs){
            findStringAnagram(string);
        }
    }

    public List<List<String>> getAnagramList(){
        List<List<String>> sortedAnagrams = new ArrayList<>();
        for(List<String> group : anagramMap.values()){
            sortedAnagrams.add(group);
        }
        return sortedAnagrams;
    }

    private void findStringAnagram(String string){
        String alphFreq = convertToAlphFreq(string);
        // if(anagramMap.containskey(alphFreq)){
        addToAnagramMap(alphFreq, string);
        // }
    }

    private String convertToAlphFreq(String string){
        int[] alphArr = new int[26];
        for(int i = 0; i < string.length(); i++){
            int alphLetterVal = string.charAt(i);
            alphArr[alphLetterVal - 97]++;
        }
        return Arrays.toString(alphArr);
    }

    private void addToAnagramMap(String alphFreq, String string){
        List<String> sameAnagram = anagramMap.getOrDefault(alphFreq, new ArrayList<>());
        sameAnagram.add(string);
        anagramMap.put(alphFreq, sameAnagram); //needed for new entries
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        GroupAnagrams anagrams = new GroupAnagrams(strs);
        anagrams.sortStrings();
        return anagrams.getAnagramList();
    }
}

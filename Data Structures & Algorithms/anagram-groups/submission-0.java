// import java.util.Arrays;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> groupMap = new HashMap<>();
        // ArrayList<String> anagramWords; 

        for (String word: strs){
            int[] alphabet = new int[26];
            for (int i = 0; i < word.length(); i++){
                // int ascii = word.charAt(i);
                // System.out.println(ascii);
                alphabet[word.charAt(i) - 'a'] += 1;
            }
            String key = Arrays.toString(alphabet);
            ArrayList<String> anagramWords = groupMap.get(key);
            if(anagramWords == null){
                anagramWords = new ArrayList<>();
            }
            // anagramWords = groupMap.getOrDefault(alphabet, new ArrayList<>());
            anagramWords.add(word);
            System.out.println(anagramWords);
            groupMap.put(key, anagramWords);
        }

        System.out.println(groupMap.toString());
        return new ArrayList<>(groupMap.values());
        // return new ArrayList<>();
    }
}

class Solution {

    public String encode(List<String> strs) {
        //list of strings into 1 long string
        //at the front of each string add it's length
        String longString = "";
        for(String list: strs){
            longString += list.length() + "-" + list;
        }

        System.out.println(longString);

        return longString;
    }

    public List<String> decode(String str) {
        //1 long string back into the list of strings
        int counter = 0;
        List<String> ogList = new ArrayList<>();
        while (counter < str.length()){
            int wordLen = 0; //str.charAt(counter) - '0'; //turn char num back into int
            String len = "" + str.charAt(counter);
            while (counter + 1 < str.length() && str.charAt(counter + 1) != '-'){
                counter ++;
                len += str.charAt(counter);
            }

            wordLen = Integer.parseInt(len);
            counter++;
            System.out.println(wordLen + " word Len");
            String ogWord = "";
            int i = 0;
            for(i = counter + 1; i < wordLen + counter + 1; i++){
                // System.out.println(i);
                ogWord += str.charAt(i);
                // System.out.println(ogWord);
            }
            counter = i;
            System.out.println(ogWord + " ogWord");
            ogList.add(ogWord);
        }
        return ogList;
    }
}

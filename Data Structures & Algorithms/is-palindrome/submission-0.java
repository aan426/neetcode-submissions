class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; //lower
        int j = s.length() - 1; //upper
        while(i <= j){
            if(!(Character.isLetterOrDigit(s.charAt(i))) || !(Character.isLetterOrDigit(s.charAt(j)))){
                if(!(Character.isLetterOrDigit(s.charAt(i)))){
                    i++;
                }
                if(!(Character.isLetterOrDigit(s.charAt(j)))){
                    j--;
                }
            }
            else{
                String iVal = s.charAt(i) + "";
                String jVal = s.charAt(j) + "";
                if(iVal.equalsIgnoreCase(jVal)){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
            
        }
        return true;
    }
}

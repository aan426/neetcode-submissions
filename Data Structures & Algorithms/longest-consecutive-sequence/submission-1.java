class LongestConsecutive{
    int[] nums;
    List<Integer> seqStarters;
    Set<Integer> allValSet;
    public LongestConsecutive(int[] nums){
        this.nums = nums;
        seqStarters = new ArrayList<>();
        allValSet = new HashSet<>();
    }

    public int main(){
        fillAllVallSet();
        findSeqStarters();
        return getLongestConsecLen();
    }

    private void fillAllVallSet(){
        for(int num: nums){
            allValSet.add(num);
        }
    }

    private void findSeqStarters(){
        for(Integer num: allValSet){
            // System.out.println(num);

            if(!allValSet.contains(num-1)){
                // System.out.println(num);
                seqStarters.add(num);
            }
        }
    }

    private int getLongestConsecLen(){
        int maxLen = 0;
        for(int seqStart: seqStarters){
            int len = countSeqStartConsecLen(seqStart);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    private int countSeqStartConsecLen(int seqStart){
        int lenCount = 1;
        int currNum = seqStart;
        while(allValSet.contains(currNum + 1)){
            lenCount++;
            currNum++;
        }
        return lenCount;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        LongestConsecutive object = new LongestConsecutive(nums);
        return object.main();
    }
}

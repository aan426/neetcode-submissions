class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> remTemps = new Stack<>();
        Stack<Integer> remTempsIndex = new Stack<>();
        int[] finalTempDiffs = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            if(remTemps.isEmpty() || temperatures[i] <= remTemps.peek()){
                remTemps.push(temperatures[i]); //current remaining temps
                remTempsIndex.push(i); //current remaining temp indicies
            }
            else{
                while(!remTemps.isEmpty() && remTemps.peek() < temperatures[i]){
                    finalTempDiffs[remTempsIndex.peek()] = i - remTempsIndex.pop();
                    remTemps.pop();
                }
                remTemps.push(temperatures[i]);
                remTempsIndex.push(i);
            }
        }
        return finalTempDiffs;
    }
}

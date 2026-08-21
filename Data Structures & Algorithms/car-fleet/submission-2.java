class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeed = new int[position.length][2];
        Stack<Integer> posStack = new Stack<>();
        for(int i = 0; i < position.length; i++){
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }
        Arrays.sort(posSpeed, (a,b) -> Integer.compare(b[0], a[0])); //sorts in descending order

        int fleetCount = position.length;
        for(int i = 0; i < position.length; i++){
            System.out.print(posSpeed[i][0]); 
            System.out.println(posSpeed[i][1]); 

            if(posStack.isEmpty()){
                posStack.push(i);
            }
            else{
                int aheadCar = posStack.peek();
                double speed1 = (target - posSpeed[aheadCar][0]) / (double)posSpeed[aheadCar][1];
                double speed2 = (target - posSpeed[i][0]) / (double)posSpeed[i][1];

                if(speed2 > speed1){
                    posStack.push(i);
                }
            }
            
        }


        return posStack.size();
    }
}

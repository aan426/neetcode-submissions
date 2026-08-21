class TimeMap {
    //use an arraylist for each key to add search and remove easily
    Map<String, ArrayList<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair<Integer, String>> arrList = new ArrayList<>();
        if(map.get(key) != null){
            arrList = map.get(key);
            // arrList.add(timestamp, value);
        }
        // else{
        Pair<Integer, String> newPair = new Pair<>(timestamp, value);
        arrList.add(newPair);
        // }
        map.put(key, arrList);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair<Integer, String>> arrList = new ArrayList<>();
        // ArrayList<String> arrList = new ArrayList<>();
        if(map.get(key) == null){
            return "";
        }
        arrList = map.get(key);
        int lower = 0;
        int upper = arrList.size() - 1;
        String res = "";
        int mid = 0;
        while(lower <= upper){
            // String pair = 
            if(arrList.get(upper).getKey() == timestamp){
                return arrList.get(upper).getValue();
            }
            if(arrList.get(lower).getKey() == timestamp){
                return arrList.get(lower).getValue();
            }

            mid = (upper + lower) /2;
            if(arrList.get(mid).getKey() == timestamp){
                return arrList.get(mid).getValue();
            }
            
            if(arrList.get(mid).getKey() < timestamp){
                res = arrList.get(mid).getValue(); //potential candidate
                lower = mid + 1;
            }
            else {//if(arrList.get(mid).key() > timestamp){
                upper = mid - 1;
            }
        }
        // while(timestamp > -1 && arrList.get(timestamp) == null){
        //     timestamp--;
        // }
        // if(timestamp == -1){
        //     return "";
        // }
        return res;
        // return arrList.get(timestamp);
    }
}

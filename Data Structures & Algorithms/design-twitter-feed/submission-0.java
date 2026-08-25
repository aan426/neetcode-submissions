class Person{
    int id;
    Set<Integer> follows;
    List<int[]> tweets; 
    public Person(){
        id = -1;
        follows = new HashSet<>();
        tweets = new ArrayList<>();
        // tweets = new PriorityQueue<>((a,b) -> b[0] - a[0]); //want maxHeap on first element in int[] 
    }

    public Person(int idNum){
        id = idNum;
        follows = new HashSet<>();
        tweets = new ArrayList<>();
    }
}
class Twitter {
    Map<Integer, Person> users;
    int tweetCount;

    public Twitter() {
        users = new HashMap<>();
        tweetCount = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(users.get(userId) == null){
            users.put(userId, new Person(userId));
        }
        int[] newTweet = new int[2];
        newTweet[0] = tweetCount;
        newTweet[1] = tweetId;
        users.get(userId).tweets.add(newTweet); //adding tweetId to the set of tweets this user has
        tweetCount ++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        if (!users.containsKey(userId)) {
            return result;
        }

        Person user = users.get(userId);

        // {timestamp, tweetId, userId, tweetIndex}
        PriorityQueue<int[]> heap =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add user's own newest tweet
        if (!user.tweets.isEmpty()) {
            int index = user.tweets.size() - 1;
            int[] tweet = user.tweets.get(index);

            heap.offer(new int[]{
                tweet[0],
                tweet[1],
                userId,
                index
            });
        }

        // Add newest tweet from every person they follow
        for (int followeeId : user.follows) {
            Person followee = users.get(followeeId);

            if (!followee.tweets.isEmpty()) {
                int index = followee.tweets.size() - 1;
                int[] tweet = followee.tweets.get(index);

                heap.offer(new int[]{
                    tweet[0],
                    tweet[1],
                    followeeId,
                    index
                });
            }
        }

        // Get at most 10 newest tweets
        while (!heap.isEmpty() && result.size() < 10) {

            int[] curr = heap.poll();

            int tweetId = curr[1];
            int personId = curr[2];
            int tweetIndex = curr[3];

            result.add(tweetId);

            // Add the next-oldest tweet from the same person
            if (tweetIndex > 0) {
                int[] nextTweet =
                    users.get(personId).tweets.get(tweetIndex - 1);

                heap.offer(new int[]{
                    nextTweet[0],
                    nextTweet[1],
                    personId,
                    tweetIndex - 1
                });
            }
        }

        return result;
    }

    
    public void follow(int followerId, int followeeId) {
        if(users.containsKey(followerId) == false){
            users.put(followerId, new Person(followerId));
        }
        if(users.containsKey(followeeId) == false){
            users.put(followeeId, new Person(followeeId));
        }
        users.get(followerId).follows.add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId) != false){
            users.get(followerId).follows.remove(followeeId);
        }
    }
}

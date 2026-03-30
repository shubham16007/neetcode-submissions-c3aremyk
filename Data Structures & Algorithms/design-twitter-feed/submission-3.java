class Tweet implements Comparable<Tweet>{

    int time;
    int tweetId;

    Tweet(int time,int tweetId){
        this.time=time;
        this.tweetId=tweetId;
    }

    public int compareTo(Tweet that){

        return that.time-this.time;
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId){
        this.userId=userId;
        followers=new HashSet<>();
        followers.add(userId);
        tweets=new LinkedList<>();
    }

    public void addTweet(Tweet t){
        tweets.add(0,t);
    }

    public void addFollowers(int followerId){
        followers.add(followerId);
    }

    public void removeFollowers(int followerId){
        followers.remove(followerId);
    }
}


class Twitter {

    HashMap<Integer,User> userMap;
    int timeCounter=0;

    public Twitter() {
        userMap=new HashMap<>();
        timeCounter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }

        User user=userMap.get(userId);
        user.addTweet(new Tweet(timeCounter,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {

         if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = userMap.get(userId);

        for (int followerId : user.followers) {
        
         if (!userMap.containsKey(followerId)) continue;


            int count = 0;

            for (Tweet tweets : userMap.get(followerId).tweets) {

                count++;

                pq.offer(tweets);

                if (count == 10) {
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (!pq.isEmpty() && index < 10) {

            Tweet tweet = pq.poll();
            result.add(tweet.tweetId);
            index++;
        }

        return result;

        
    }
    
    public void follow(int followerId, int followeeId) {

        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }

        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }

        User user=userMap.get(followerId);
        user.addFollowers(followeeId);
        
    }
    
   public void unfollow(int followerId, int followeeId) {

    if (!userMap.containsKey(followerId)) {
        return;
    }

    if (followerId == followeeId) {
        return;
    }

    User user = userMap.get(followerId);
    user.removeFollowers(followeeId);
}
}

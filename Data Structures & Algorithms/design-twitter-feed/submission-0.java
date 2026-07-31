class Twitter {
    public static class Tweet{
        int tweetId;
        int time;
        public Tweet(int id , int time){
            this.tweetId = id;
            this.time = time;
        }
    };

    HashMap<Integer, List<Tweet>>tweetUser = new HashMap<>();
    HashMap<Integer, Set<Integer>>following = new HashMap<>();
    int globalTime=0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetUser.putIfAbsent(userId, new ArrayList<>());
        tweetUser.get(userId).add(new Tweet(tweetId , globalTime++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet>minHeap = new PriorityQueue<>((a,b)-> a.time-b.time);

        if(tweetUser.containsKey(userId)){
            for(Tweet tweet: tweetUser.get(userId)){
                minHeap.offer(tweet);
                if(minHeap.size() > 10){
                    minHeap.poll();
                }
            }
        }

        if(following.containsKey(userId)){
            for(Integer followeeId: following.get(userId)){
                if(tweetUser.containsKey(followeeId)){
                    for(Tweet tweet: tweetUser.get(followeeId)){
                        minHeap.offer(tweet);
                        if(minHeap.size() > 10){
                            minHeap.poll();
                        }
                    }
                }
            }
        }

        List<Integer>res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(0, minHeap.poll().tweetId);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}

class Twitter {

    // user -> people they follow
    Map<Integer, Set<Integer>> followMap;

    // user -> tweets
    Map<Integer, List<Tweet>> tweetMap;

    int time;

    public Twitter() {

        followMap = new HashMap<>();
        tweetMap = new HashMap<>();

        time = 0;
    }

    class Tweet {

        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(
            new Tweet(tweetId, time++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>(
                (a, b) -> b.time - a.time
            );

        // User should see own tweets
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Collect tweets from followed users
        for (int followee : followMap.get(userId)) {

            List<Tweet> tweets =
                tweetMap.getOrDefault(
                    followee,
                    new ArrayList<>()
                );

            for (Tweet t : tweets) {
                maxHeap.offer(t);
            }
        }

        List<Integer> feed = new ArrayList<>();

        int count = 0;

        while (!maxHeap.isEmpty() && count < 10) {

            feed.add(maxHeap.poll().id);

            count++;
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)
            && followeeId != followerId) {

            followMap.get(followerId)
                     .remove(followeeId);
        }
    }
}
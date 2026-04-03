class Tweet {
    int id;
    int time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Tweet(int id, int time) {
		super();
		this.id = id;
		this.time = time;
	}
    
}
class Twitter {

	Map<Integer, List<Tweet>> tweets = new HashMap<>();
	Map<Integer, Set<Integer>> followers = new HashMap<>();
	int t=0;

	public Twitter() {
		tweets = new HashMap<>();
		followers = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		List<Tweet> value = tweets.getOrDefault(userId, new ArrayList<>());
		value.add(new Tweet(tweetId,this.t++));
		tweets.put(userId, value);
	}

	public List<Integer> getNewsFeed(int userId) {

		PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time)); // min heap

        Set<Integer> follow = new HashSet<>(followers.getOrDefault(userId, new HashSet<>()));
        follow.add(userId);

        for (int f : follow) {
            List<Tweet> list = tweets.getOrDefault(f, new ArrayList<>());

            // Only take recent tweets (optimize)
            for (int i = list.size() - 1; i >= 0; i--) {
                pq.offer(list.get(i));
                if (pq.size() > 10) {
                    pq.poll(); // remove oldest
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().id);
        }

        Collections.reverse(res); // latest first
        return res;
	}

	public void follow(int followerId, int followeeId) {
		Set<Integer> value = followers.getOrDefault(followerId, new HashSet<>());
		value.add(followeeId);
		followers.put(followerId, value);
	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> value = followers.get(followerId);
		value.remove(Integer.valueOf(followeeId));
		followers.put(followerId, value);
	}
}

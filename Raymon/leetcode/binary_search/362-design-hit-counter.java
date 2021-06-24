class HitCounter {
    private int total;
    private Deque<Pair<Integer, Integer>> deque;
    /** Initialize your data structure here. */
    public HitCounter() {
        total = 0;
        deque = new LinkedList<>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (deque.size() == 0 || deque.getLast().getKey() != timestamp) {
            deque.offerLast(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            Pair<Integer, Integer> element = deque.pollLast();
            deque.offerLast(new Pair<Integer, Integer>(timestamp, element.getValue() + 1));
        }
        total++;
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!deque.isEmpty() && timestamp - deque.getFirst().getKey() >= 300) {
            total -= deque.getFirst().getValue();
            deque.pollFirst();
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

class KthLargest {
    PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
    int kth;
    public KthLargest(int k, int[] nums) {
        kth = k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        int tofound = kth-1;
        List<Integer>ar = new ArrayList<>();
        while(tofound > 0){
            ar.add(pq.peek());
            pq.poll();
            tofound--;
        }
        int ans = pq.peek();
        for(int i=0;i<ar.size();i++){
            pq.add(ar.get(i));
        }
        return ans;
    }
}

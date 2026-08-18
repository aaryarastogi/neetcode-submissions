class Solution {
    class Element implements Comparable<Element>{
        int val;
        int index;
        public Element(int val, int index){
            this.val = val;
            this.index=index;
        }
        @Override
        public int compareTo(Element other){
            return Integer.compare(other.val, this.val);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer>ans = new ArrayList<>();
        PriorityQueue<Element>maxHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            maxHeap.add(new Element(nums[i],i));
            int leftboundary = i-k+1;

            while(!maxHeap.isEmpty() && maxHeap.peek().index < leftboundary){
                maxHeap.poll();
            }

            if(i>=k-1){
                ans.add(maxHeap.peek().val);
            }
        }   

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

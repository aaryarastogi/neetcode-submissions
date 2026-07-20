class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.peek();
            maxHeap.poll();
            int y = maxHeap.peek();
            maxHeap.poll();
            if(x==y) continue;
            else{
                maxHeap.add(Math.abs(x-y));
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}

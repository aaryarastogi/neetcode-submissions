class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>count = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            count.put(tasks[i], count.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Character ct : count.keySet()) {
            pq.add(count.get(ct)); 
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer>arr = new ArrayList<>();
            int cycle=n+1;
            while(!pq.isEmpty() && cycle>0){
                int currFreq = pq.poll();
                if(currFreq-1 > 0){
                    arr.add(currFreq-1);
                }
                time++;
                cycle--;
            }
            for(int rem:arr){
                pq.add(rem);
            }
            if(!pq.isEmpty()){
                time+=cycle;
            }
        }

        return time;
    }
}

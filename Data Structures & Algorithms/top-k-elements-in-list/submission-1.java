class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hm = new HashMap<>(); //integer freq
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        Map<Integer, List<Integer>>count = new TreeMap<>(Collections.reverseOrder());
        //freq integer
        for(Integer x: hm.keySet()){
            List<Integer>curr = new ArrayList<>();
            if(count.containsKey(hm.get(x))){
                curr = count.get(hm.get(x));
            }
            curr.add(x);
            count.put(hm.get(x), curr);
        }

        int[] ans = new int[k];
        int i=0;
        for(Integer freq : count.keySet()){
            List<Integer>elements = count.get(freq);
            for(Integer e: elements){
                System.out.println(e);
                if(k>0){
                    ans[i] = e;
                    k--;
                    i++;
                }
            }
        }
        return ans;
    }
}

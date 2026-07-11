class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,List<Integer>>hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                List<Integer>curr = hm.get(nums[i]);
                curr.add(i);
                hm.put(nums[i],curr);
            }
            else{
                List<Integer>curr = new ArrayList<>();
                curr.add(i);
                hm.put(nums[i],curr);
            }
        }

        for(int i=0;i<nums.length;i++){
            int tofind = target-nums[i];
            if(hm.containsKey(tofind)){
                List<Integer>curr = hm.get(tofind);
                for(int j=0;j<curr.size();j++){
                    if(i != curr.get(j)){
                        return new int[]{i, curr.get(j)};
                    }
                }
            }
        }
        return new int[]{-1};
    }
}

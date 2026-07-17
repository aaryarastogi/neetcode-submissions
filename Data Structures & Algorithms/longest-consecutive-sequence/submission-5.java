class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        HashSet<Integer>present = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            present.add(nums[i]);
        }

        int ans = 1;
        for(int i=0;i<nums.length;i++){
            int currStreak=1;
            int curr = nums[i];
            while(present.contains(curr+1)){
                curr+=1;
                currStreak++;
            }

            ans = Math.max(ans,currStreak);
        }
        
        return ans;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = (nums[i]<0 ? nums[i]*-1 : nums[i]) -1;

            if(nums[index] < 0){
                return (nums[i]<0 ? nums[i]*-1 : nums[i]);
            }
            nums[index] *= -1;
        }
        return -1;
    }
}

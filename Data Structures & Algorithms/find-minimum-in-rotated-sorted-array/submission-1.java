class Solution {
    public int findMin(int[] nums) {
        int i=0, j=nums.length-1;
        int mini = Integer.MAX_VALUE;

        while(i<=j){
            int mid = (i+j)/2;
            mini = Math.min(mini,nums[mid]);
            if(nums[mid] > nums[j]){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }

        return mini;
    }
}
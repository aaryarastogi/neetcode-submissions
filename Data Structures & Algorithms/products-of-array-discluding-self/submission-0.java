class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        prefixProduct[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixProduct[i] = prefixProduct[i-1]*nums[i];
        }

        int[] suffixProduct = new int[n];
        suffixProduct[n-1] = nums[n-1];
        for(int j=n-2;j>=0;j--){
            suffixProduct[j] = suffixProduct[j+1]*nums[j];
        }

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(i>0 && i<n-1){
                ans[i] = prefixProduct[i-1] * suffixProduct[i+1];
            }
            else if(i==0){
                ans[i] = suffixProduct[i+1];
            }
            else{
                ans[i] = prefixProduct[i-1];
            }
        }
        return ans;
    }
}  

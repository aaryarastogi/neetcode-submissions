class Solution {
    public int findMax(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public long countHours(int[] piles, int mid){
        long ans=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]%mid == 0){
                ans += piles[i]/mid;
            }
            else{
                ans += (piles[i])/mid + 1;
            }
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);
        int ans = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left+right)/2;
            long taking = countHours(piles,mid);
            if(taking <= h){
                ans = Math.min(ans,mid);
                right = mid-1;
            }
            else left = mid+1;
        }

        return ans;
    }
}
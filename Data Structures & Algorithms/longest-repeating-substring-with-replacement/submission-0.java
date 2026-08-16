class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        HashMap<Character, Integer>hm = new HashMap<>();
        int maxFreq = 0;
        int maxSize=0;

        for(int r=0;r<s.length();r++){
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0)+1);
            maxFreq = Math.max(maxFreq, hm.get(s.charAt(r)));
            if(r-l+1 - maxFreq > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
            }
            maxSize = Math.max(maxSize, r-l+1);
        }

        return maxSize;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s=="" || s==null){
            return 0;
        }
        HashSet<Character>hs = new HashSet<>();
        int l=0;
        int maxSize=0;

        for(int r=0;r<s.length();r++){
            while(hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            maxSize = Math.max(maxSize, r-l+1);
        }

        return maxSize;
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || t.length() > s.length()) return "";
        if(s.equals(t)) return s;

        int[] targetFreq = new int[128];
        for(char c: t.toCharArray()){
            targetFreq[c]++;
        }

        int l=0, r=0;
        int minSize=Integer.MAX_VALUE;
        int formed=0;
        int required = t.length();
        int startIndex=0;

        int[] currWindow = new int[128];
        while(r < s.length()){
            currWindow[s.charAt(r)]++;

            if(targetFreq[s.charAt(r)] > 0 && currWindow[s.charAt(r)] <= targetFreq[s.charAt(r)]){
                formed++;
            }

            while(formed == required){
                currWindow[s.charAt(l)]--;
                if(r-l+1 < minSize){
                    minSize=r-l+1;
                    startIndex=l;
                }

                if(targetFreq[s.charAt(l)]>0 && currWindow[s.charAt(l)] < targetFreq[s.charAt(l)]){
                    formed--;
                }
                l++;
            }
            r++;
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(startIndex , startIndex+minSize);
    }
}

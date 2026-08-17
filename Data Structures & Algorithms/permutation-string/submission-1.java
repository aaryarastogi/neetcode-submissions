class Solution {
    static boolean isPermutation(String s1 , String str){
        char[] c1 = s1.toCharArray();
        char[] c2 = str.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int windowSize = s1.length();
        String substr = s2.substring(0,windowSize);
        if(isPermutation(substr,s1)) return true;

        for(int i=1;i<=s2.length()-s1.length();i++){
            if(isPermutation(s2.substring(i, i+windowSize), s1)) return true;
        }

        return false;
    }
}

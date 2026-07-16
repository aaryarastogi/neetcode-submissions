class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String>ans = new ArrayList<>();

        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!= '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;

            String s = str.substring(i,i+length);
            ans.add(s);
            i+=length;
        }

        return ans;
    }
}

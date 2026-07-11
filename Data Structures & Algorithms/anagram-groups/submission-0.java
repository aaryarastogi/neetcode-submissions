class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>hm = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] count = new int[26];
            for(int j=0;j<strs[i].length();j++){
                count[strs[i].charAt(j)-'a']++;
            }

            String key = Arrays.toString(count);

            List<String> curr = hm.getOrDefault(key, new ArrayList<>());
            curr.add(strs[i]);
            hm.put(key,curr);
        }

        return new ArrayList<>(hm.values());
    }
}

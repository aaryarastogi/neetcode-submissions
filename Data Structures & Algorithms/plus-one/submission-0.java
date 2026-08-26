class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0; 
        List<Integer> ans = new ArrayList<>();

        for(int i=len-1;i>=0;i--){
            int sum = digits[i]+carry;
            if(i==len-1){
                sum+=1;
            }
            carry = sum/10;
            ans.add(sum%10);
        }
        if(carry>0){
            ans.add(carry);
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}

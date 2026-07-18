class Solution {
    public int applyOperation(int op1 , int op2 , String curr){
        if(curr.equals("+")){
            return op1+op2;
        }
        else if(curr.equals("-")){
            return op2-op1;
        }
        else if(curr.equals("*")){
            return op1*op2;
        }
        else{
            return op2/op1;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            String curr = tokens[i];
            
            if(curr.equals("-") || curr.equals("+") || curr.equals("*") || curr.equals("/")){
                int op1 = st.peek();
                st.pop();
                int op2 = st.peek();
                st.pop();

                int ans = applyOperation(op1,op2,curr);
                st.push(ans);
            }
            else{
                int val = Integer.parseInt(curr);
                st.push(val);
            }
        }

        return st.peek();
    }
}

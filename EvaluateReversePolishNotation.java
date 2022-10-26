class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans = Integer.parseInt(tokens[0]);
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int pop2 = st.pop();
                int pop1 = st.pop();
                int evaluatedValue = 0;
                if(s.equals("+"))
                    evaluatedValue = pop1 + pop2;
                else if(s.equals("-"))
                    evaluatedValue = pop1 - pop2;
                else if(s.equals("*"))
                    evaluatedValue = pop1 * pop2;
                else
                    evaluatedValue = pop1 / pop2;
                ans = evaluatedValue;
                st.push(evaluatedValue);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return ans;
    }
}

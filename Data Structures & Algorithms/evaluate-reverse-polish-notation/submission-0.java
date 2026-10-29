//Approach => Using stack,while traversing the Array if any number comes directly push it onto the stack otherwise if an operator comes then pop the last two elements and perform the operation and push the result onto stack. 
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a=st.pop();
                int b=st.pop();
                st.push(a+b);
            }
            else if(tokens[i].equals("-")){
                int a=st.pop();
                int b=st.pop();
                st.push(b-a);
            }
            else if(tokens[i].equals("*")){
                int a=st.pop();
                int b=st.pop();
                st.push(a*b);
            }
            else if(tokens[i].equals("/")){
                int a=st.pop();
                int b=st.pop();
                st.push(b/a);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
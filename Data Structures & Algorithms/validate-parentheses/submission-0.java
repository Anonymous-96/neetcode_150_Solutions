//Aproach ==> Using Stack, if any opening bracket comes push it if not then compare it with the to of stack if emty then not a valid parantheses and if matches then pop the top of stack 
class Solution {
    boolean sameStyle(char top,char ch){
            if(top=='(' && ch==')') return true;
            if(top=='{' && ch=='}') return true;
            if(top=='[' && ch==']') return true;
            return false;
        }
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        int n=s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if(sameStyle(top,s.charAt(i))) st.pop();
                else return false;
            }
        }
        return st.size()==0;
    }
}

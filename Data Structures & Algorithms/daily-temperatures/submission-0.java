//Appraoch => Using Monotonic Stack, travere from left to right and if value at top is greater then push the incoming value else pop out until the value is less or stack gets empty and the day will be the top value - the present day 
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n=temperatures.length; 
        int[] res= new int[n];   
        for(int i=n-1;i>=0;i--){
            int t =temperatures[i];
            while(!st.isEmpty() && t>=temperatures[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) res[i]=0;
            else{
                res[i]=st.peek()-i;
            }
            st.push(i);
        }
        return res;
    }
}

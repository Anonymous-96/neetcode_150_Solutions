//Here simple trick is that car which is nearest we start from that position and check the car behind it is that car reaching early if yes then it will get merged and make a fleet i.e. currTime < prevTime and if the time it takes is greater than the car next to it in direction of target the it will make a separate fleet so we will increase the count and also update the prevTime.
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] pair= new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair,(a,b)-> Integer.compare(b[0],a[0]));
        int fleets=1;
        double prevTime=(double)(target - pair[0][0])/pair[0][1];
        for(int i=1;i<n;i++){
            double currTime = (double)(target-pair[i][0])/pair[i][1];
            if(currTime > prevTime){
                fleets++;
                prevTime=currTime;
            }
        } 
        return fleets;     
    }
}

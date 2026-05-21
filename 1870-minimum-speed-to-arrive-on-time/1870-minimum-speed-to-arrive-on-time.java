class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if(hour<=n-1){
            return -1;
        }
        int low =1;
        int high = 10000000;
        while(low<high){
            int mid=low+(high-low)/2;
            if(canReach(dist,hour,mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
            return low;
        }
        private boolean canReach(int []dist , double hour , int speed){
            double time=0.0;
            for(int i=0;i<dist.length-1;i++){
                time+=(dist[i]+speed-1)/speed;
                if(time>hour){
                    return false;
                }
            }
            time+=(double)dist[dist.length-1]/speed;
            return time<=hour;
        
    }
}
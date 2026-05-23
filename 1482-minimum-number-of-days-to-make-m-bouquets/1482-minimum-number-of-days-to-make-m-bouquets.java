class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long)m*k;
        if(totalFlowers > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<bloomDay.length;i++){
            low = Math.min(low,bloomDay[i]);
            high =Math.max(high,bloomDay[i]);
        }
        while(low<=high){
            int mid = low +(high-low)/2;
            if(canMake(bloomDay,m,k,mid)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean canMake(int[] bloomDay,int m,int k,int Day){
        int boquets = 0 , flowers =0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=Day){
                flowers++;
                if(flowers==k){
                    boquets++;
                    flowers=0;
                }
            }
                else{
                    flowers =0;
                }
        }
        return boquets>=m;
    }
}
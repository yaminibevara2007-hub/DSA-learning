class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1 , high =0;
        for(int Pile : piles){
            high = Math.max(high,Pile);
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high -low)/2;
            long hours =0;
            for(int Pile:piles){
               hours+=(Pile+mid-1)/mid;
            }
            if(hours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
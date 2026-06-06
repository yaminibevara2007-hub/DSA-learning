class Solution {
    public int splitArray(int[] nums, int k) {
        int low =0, high =0;
        for(int i=0;i<nums.length;i++){
            low =Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<high){
            int mid = low+(high-low)/2;
            if(canSplit(nums,k,mid)){
                high = mid;
            }
            else{
                low = (int)mid+1;
            }
        }
        return low;
    }
    private boolean canSplit(int[] nums, int k,long maxSum){
        int count =1;
        long curSum=0;
        for(int i=0;i<nums.length;i++){
            if(curSum + nums[i]>maxSum){
                count++;
                curSum=nums[i];
            }
            else{
                curSum+=nums[i];
            }
        }
        return count<=k;
    }
}
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total_sum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMaxsum = 0;
        int curMinsum = 0;

        for(int i=0;i<nums.length;i++){
            curMaxsum = Math.max( nums[i] , curMaxsum+nums[i]);
            curMinsum = Math.min( nums[i] , curMinsum+nums[i]);

            maxSum = Math.max( maxSum , curMaxsum);
            minSum = Math.min( minSum , curMinsum);

            total_sum+=nums[i];
        }
        if(maxSum<0){
            return maxSum;
        }
        return Math.max( maxSum , total_sum - minSum );
    }
}
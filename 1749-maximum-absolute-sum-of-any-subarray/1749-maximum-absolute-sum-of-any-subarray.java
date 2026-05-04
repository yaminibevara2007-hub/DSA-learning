class Solution {
    public int maxAbsoluteSum(int[] nums) {
      int maxSum=0 ;
      int minSum=0 ;
      int maxEnd=0 ;
      int minEnd=0 ;

      for(int i=0;i<nums.length;i++){

        maxEnd = Math.max( nums[i] , maxEnd + nums[i]);
        maxSum = Math.max( maxSum, maxEnd);

        minEnd = Math.min( nums[i] , minEnd + nums[i]);
        minSum = Math.min( minSum , minEnd );

      }
      return Math.max( Math.abs(maxSum) , Math.abs(minSum));
    }
}
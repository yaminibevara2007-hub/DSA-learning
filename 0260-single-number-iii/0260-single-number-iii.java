class Solution {
    public int[] singleNumber(int[] nums) {
        int xor =0;
        for(int i =0;i<nums.length;i++){
            xor ^= nums[i];
        }
        int mask = xor & (-xor);
        int nums1 = 0;
        int nums2 = 0;
        for(int i=0;i<nums.length;i++){
            if((mask & nums[i])!=0){
                nums1 ^= nums[i];
            }
            else{
                 nums2 ^= nums[i];
            }
        }
        return new int[]{nums1 , nums2};
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int b[]=new int[n];
        for(int i=0;i<n;i++){
            b[(i+k)%n]=nums[i];
        }
        for(int i=0;i<nums.length;i++)
        nums[i]=b[i];
            }
}
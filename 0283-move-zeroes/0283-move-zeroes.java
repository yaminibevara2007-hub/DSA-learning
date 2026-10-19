class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int []a=new int[n];
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                a[k]=nums[i];
                k++;
            }
        }
        for(int i=0;i<a.length;i++){
            nums[i]=a[i];
        }
        
    }
}
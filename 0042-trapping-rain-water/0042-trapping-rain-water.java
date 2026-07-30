class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int water=0;
        int lmax=height[left],rmax=height[right];
        while(left<right){
            if(lmax < rmax){
                left++;
                lmax=Math.max(lmax,height[left]);
                water+=lmax - height[left];
            }
            else{
                right--;
                rmax = Math.max(rmax,height[right]);
                water+= rmax - height[right];
            }
        }
        return water;
    }
}
class Solution {
    public int maxArea(int[] height) {
        int L=0;
        int R=height.length-1;
        int maxWater=0;
        while( L <= R){
            int h =Math.min(height[L],height[R]);
            int width=R-L;
            int area = h * width;
            maxWater = Math.max(maxWater,area);
        
        if(height[L]<height[R]){
            L++;
        }
        else{
            R--;
        }
        }
        return maxWater;

    }
}
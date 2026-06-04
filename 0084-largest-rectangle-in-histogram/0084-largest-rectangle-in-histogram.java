class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea =0;
        int n = heights.length;
        for(int i=0;i<=n;i++){
            int curHeight = (i==n)? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()]>curHeight){
                int height = heights[st.pop()];
                int r=i;
                int l=st.isEmpty()?-1:st.peek();
                int width = r-l-1;
                maxArea = Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
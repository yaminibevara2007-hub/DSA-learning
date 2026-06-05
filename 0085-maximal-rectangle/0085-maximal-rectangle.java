class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int heights[]=new int[col];
        int maxArea =0;
        for(int r=0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(matrix[r][c]=='1'){
                    heights[c]++;
                }
                else{
                    heights[c]=0;
                }
            }
            maxArea = Math.max(maxArea , largestRectangle(heights));
        }
        return maxArea;
        
    }
    private int largestRectangle(int []heights){
        Stack<Integer> st = new Stack<>();
        int maxArea =0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int curHeight =(i==n)?0:heights[i];
            while(!st.isEmpty() && curHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int left = st.isEmpty()?-1:st.peek();
                int width =i - left-1;
                maxArea = Math.max(maxArea , height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
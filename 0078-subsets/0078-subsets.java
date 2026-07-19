class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int subset = (1<<n);
        for(int i = 0 ;i<subset;i++){
            List<Integer> Subsets = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    Subsets.add(nums[j]);
                }
            }
            ans.add(Subsets);
        }
         return ans;
    }
}
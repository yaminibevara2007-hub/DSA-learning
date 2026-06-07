class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums ,k-1);
    }
    private int atmost(int[] nums,int k){
        int left =0 ,count=0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int r=0;r<nums.length;r++){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            while(freq.size()>k){
                freq.put(nums[left],freq.get(nums[left])-1);
                if(freq.get(nums[left])==0){
                    freq.remove(nums[left]);
                }
                left++;
            }
            count+=(r - left+1);
        }
        return count;
    }
}
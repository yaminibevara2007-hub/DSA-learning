class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i =0; i < nums.length;i++){
            // map.put(map.get(i),map.getOrDefault(map.get(i),0)+1);
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],1);
        }
        return false;
    }
}
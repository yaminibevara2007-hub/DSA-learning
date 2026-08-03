class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1 = 0;
        int p2 =0;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i =0 ; i < n1 ; i++){
            set1.add(nums1[i]);
        }
        for(int i =0 ;i< n2;i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] a = new int[set2.size()];
        int i =0;
        for(int num : set2){
            a[i] = num;
            i++;
        }
        return a;
    }
}
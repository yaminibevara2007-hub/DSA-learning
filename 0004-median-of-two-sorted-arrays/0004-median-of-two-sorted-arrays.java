class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double res = merge(nums1 , nums2);
      
    return res;
        
        
    }
    private static double merge(int[] nums1,int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1 = 0;
        int p2 = 0;
        List<Integer> ans = new ArrayList<>();
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] < nums2[p2]){
                ans.add(nums1[p1]);
                p1++;
            }
            else{
                ans.add(nums2[p2]);
                p2++;
            }

        }
        while(p1 < n1){
            ans.add(nums1[p1]);
            p1++;
        }
        while(p2 < n2){
            ans.add(nums2[p2]);
            p2++;
        }
        double res =0;
        int temp[] = new int[ans.size()];
        for(int i =0 ;i < ans.size() ;i++){
            temp[i] = ans.get(i);
        }
        int n = temp.length;
    if(n % 2 !=0){
        res = temp[n/2];
    }
    else{
        res = temp[n/2 ] +temp[(n/2) -1];
        res = res/2;
    }

        return res;
    }
}
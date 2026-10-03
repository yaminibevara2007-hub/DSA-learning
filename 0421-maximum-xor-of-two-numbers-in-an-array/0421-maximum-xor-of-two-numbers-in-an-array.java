// class Solution {
//     public int findMaximumXOR(int[] nums) {
//         int max = 0;

//         for (int i = 0; i < nums.length - 1; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 max = Math.max(max, nums[i] ^ nums[j]);
//             }
//         }

//         return max;
//     }
// }
import java.util.*;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            set.clear();

            for (int num : nums) {
                set.add(num & mask);
            }

            int candidate = max | (1 << i);

            for (int num : nums) {
                if (set.contains((num & mask) ^ candidate)) {
                    max = candidate;
                    break;
                }
            }
        }

        return max;
    }
}
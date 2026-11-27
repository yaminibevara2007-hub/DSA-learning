class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;
        int[] free = new int[n];

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cost = items[i][1];
            int value = 1 + free[i];

            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + value);
            }
        }

        int ans = 0;

        for (int b = 0; b <= budget; b++) {
            int remaining = budget - b;
            int total = dp[b] + remaining / minPrice;
            ans = Math.max(ans, total);
        }

        return ans;
    }
}
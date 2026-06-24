class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(1, k, n, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int start,
                       int k,
                       int target,
                       List<Integer> path,
                       List<List<Integer>> ans) {

        if (path.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {

            if (i > target) break; // pruning

            path.add(i);

            solve(i + 1, k, target - i, path, ans);

            path.remove(path.size() - 1);
        }
    }
}
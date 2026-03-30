
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates); // 🔥 important
        dfs(0, candidates, new ArrayList<>(), target);
        return result;
    }

    private void dfs(int start, int[] candidates, List<Integer> path, int target) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {

            // 🔥 skip duplicates at same level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);

            // i+1 because element can be used only once
            dfs(i + 1, candidates, path, target - candidates[i]);

            path.remove(path.size() - 1);
        }
    }
}
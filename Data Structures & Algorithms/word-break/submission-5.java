class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return dfs(s, wordSet, 0, memo);
    }

    private boolean dfs(String s, HashSet<String> wordSet, int i, Boolean[] memo) {

        if (i == s.length()) {
            return true;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        for (int j = i; j < s.length(); j++) {

            if (wordSet.contains(s.substring(i, j + 1))) {

                if (dfs(s, wordSet, j + 1, memo)) {
                    memo[i] = true;
                    return true;
                }
            }
        }

        memo[i] = false;
        return false;
    }
}
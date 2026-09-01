public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        List<String>[] dp = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.contains(s.substring(j, i))) {
                    for (String sentence : dp[j]) {
                        dp[i].add((sentence + " " + s.substring(j, i)).trim());
                    }
                }
            }
        }

        return dp[n];
    }
}
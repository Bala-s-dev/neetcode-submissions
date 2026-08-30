class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));

        int n = s.length();
        int[] dp = new int[n + 1];

        // Worst case: every character is extra
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {

            // Treat s[i - 1] as an extra character
            dp[i] = dp[i - 1] + 1;

            // Try every possible word ending at i
            for (int j = 0; j < i; j++) {

                String word = s.substring(j, i);

                if (wordSet.contains(word)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}
class Solution {

    public List<Integer> topo(int k, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[k];
        List<Integer> topo = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            for (int nei : adj.get(i)) {
                indeg[nei]++;
            }
        }

        for (int i = 0; i < k; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int nei : adj.get(node)) {
                indeg[nei]--;

                if (indeg[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return topo;
    }

    public String foreignDictionary(String[] words) {

        int n = 26;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] exists = new boolean[26];
        int charCount = 0;

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!exists[ch - 'a']) {
                    exists[ch - 'a'] = true;
                    charCount++;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {

                if (s1.charAt(j) != s2.charAt(j)) {

                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';

                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                    }

                    break;
                }
            }
        }

        List<Integer> topo = topo(n, adj);

        StringBuilder ans = new StringBuilder();

        int usedCharsSeen = 0;

        for (int node : topo) {
            if (exists[node]) {
                ans.append((char) (node + 'a'));
                usedCharsSeen++;
            }
        }

        // cycle among used characters
        if (usedCharsSeen != charCount) {
            return "";
        }

        return ans.toString();
    }
}
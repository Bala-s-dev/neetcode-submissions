class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int m = t.length();

        for (int i = 0; i < m; i++) {
            map.put(t.charAt(i),
                    map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;

        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int sInd = -1;

        while (r < n) {

            char rc = s.charAt(r);

            if (map.containsKey(rc)) {
                if (map.get(rc) > 0) {
                    count++;
                }

                map.put(rc, map.get(rc) - 1);
            }

            while (count == m) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sInd = l;
                }

                char lc = s.charAt(l);

                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);

                    if (map.get(lc) > 0) {
                        count--;
                    }
                }

                l++;
            }

            r++;
        }

        return sInd == -1
                ? ""
                : s.substring(sInd, sInd + minLen);
    }
}
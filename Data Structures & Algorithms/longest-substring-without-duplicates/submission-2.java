class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int len = s.length();

        int maxWindow = 0;
        while(r < len){
            char c = s.charAt(r);
            
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            maxWindow = Math.max(maxWindow, r - l + 1);
            r++;
        }
        return maxWindow;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        //Brute force
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            int maxFreq = -1;
            int count = 0;
            for(int j = i; j < n; j++){
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(c));
                count = (j - i + 1) - maxFreq;

                if(count <= k){
                    maxLen = Math.max(maxLen, (j - i + 1));
                } 
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}

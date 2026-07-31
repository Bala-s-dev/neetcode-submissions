class Solution {
    public int characterReplacement(String s, int k) {
        //optimal
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int maxLen = 0;

        int hash[] = new int[26];

        while(r < n){
            char rc = s.charAt(r);
            hash[rc - 'A']++;
            maxFreq = Math.max(maxFreq, hash[rc - 'A']);

            //shrink the window
            while((r - l + 1) - maxFreq > k){
                char lc = s.charAt(l);
                hash[lc - 'A']--;
                maxFreq = 0;
                for(int i = 0; i < 26; i++){
                    if(hash[i] > maxFreq){
                        maxFreq = hash[i];
                    }
                }
                l++;
            }

            if((r - l + 1) - maxFreq <= k){
                maxLen = Math.max(maxLen, (r - l + 1));
            }
            r++;
        }

        return maxLen;


        //Brute force
        // int n = s.length();
        // int maxLen = 0;
        // for(int i = 0; i < n; i++){
        //     HashMap<Character, Integer> map = new HashMap<>();
        //     int maxFreq = -1;
        //     int count = 0;
        //     for(int j = i; j < n; j++){
        //         char c = s.charAt(j);
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //         maxFreq = Math.max(maxFreq, map.get(c));
        //         count = (j - i + 1) - maxFreq;

        //         if(count <= k){
        //             maxLen = Math.max(maxLen, (j - i + 1));
        //         } 
        //         else {
        //             break;
        //         }
        //     }
        // }
        // return maxLen;
    }
}

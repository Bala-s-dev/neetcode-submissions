class Solution {

    public static boolean anagram(String one, String two){
        if(one.length() != two.length()) return false;

        int[] arr = new int[26];
        for(int i = 0; i < one.length(); i++){
            arr[one.charAt(i) - 'a']++;
            arr[two.charAt(i) - 'a']--;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for(int i = 0; i < strs.length; i++){
            if (visited[i]) continue;

            List<String> inList = new ArrayList<>();
            inList.add(strs[i]);
            visited[i] = true;

            for(int j = i + 1; j < strs.length; j++){
                if (!visited[j] && anagram(strs[i], strs[j])) {
                    inList.add(strs[j]);
                    visited[j] = true;
                }
            }

            groupAnagrams.add(inList);
        }

        return groupAnagrams;
    }
}

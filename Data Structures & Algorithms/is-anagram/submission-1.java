class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int arr[] = new int[26];

        int len = s.length();
        for(int i = 0; i < len; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0) return false;
            // System.out.print("i = " + arr[i]);
        }
        return true;
    }
}

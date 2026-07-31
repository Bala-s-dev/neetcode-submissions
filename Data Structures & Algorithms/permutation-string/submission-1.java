class Solution {
    public boolean checkPerm(char[] str1, char[] str2){
        int n = str1.length;
        for(int i = 0; i < n; i++){
            if(str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        char str1[] = s1.toCharArray();
        Arrays.sort(str1);

        int l = 0;
        // int rlen = s1.length();
        int r = s1.length() - 1;

        int len = s2.length();
        while(r < len){
            char str2[] = (s2.substring(l, r + 1)).toCharArray();
            Arrays.sort(str2);
            if(checkPerm(str1, str2)){
                return true;
            }
            l++;
            r++;       
        }
        return false;
    }
}

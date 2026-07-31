class Solution {
    public boolean checkPal(int s, int e, String str){
        while(s <= e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        String ans = "";
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(checkPal(i, j, s)){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
}

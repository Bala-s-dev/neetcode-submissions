class Solution {
    int cnt = 0;
    public boolean checkPal(String str){
        int s = 0;
        int e = str.length() - 1;

        while(s <= e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(checkPal(s.substring(i, j + 1))){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

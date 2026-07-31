class Solution {
    public boolean checkValid(String s, int len){
        int open = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                open--;
            }

            if(open < 0){
                return false;
            }
        }
        return (open == 0) ? true : false;
    }

    public void generate(String val, List<String> ans, int len){
        if(val.length() == len){
            if(checkValid(val, len)){
                ans.add(val);
            }
            return;
        }
        generate(val + '(', ans, len);
        generate(val + ')', ans, len);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int len = 2 * n;
        String val = "";
        generate(val ,ans, len);
        return ans;
    }
}

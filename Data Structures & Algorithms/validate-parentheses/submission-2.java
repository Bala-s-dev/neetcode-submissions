class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stc = new Stack<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == ')' || c == ']' || c == '}'){
                if(!stc.isEmpty() && stc.peek() == map.get(c)){
                    stc.pop();
                }
                else {
                    return false;
                }
            }
            else{
                stc.push(c);
            }
        }
        return stc.isEmpty();
    }
}

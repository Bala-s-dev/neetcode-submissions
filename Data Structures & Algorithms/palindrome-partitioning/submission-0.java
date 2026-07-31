class Solution {
    public void checkpart(int start, String s, List<List<String>> ans, List<String> temp){
        if(start == s.length()){
            ans.add(new ArrayList<>(temp));
        }
        for(int i = start; i < s.length(); i++){
            if(checkpal(s, start, i)){
                temp.add(s.substring(start, i + 1));
                checkpart(i + 1, s, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean checkpal(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        checkpart(0, s, ans, temp);
        return ans;
    }
}

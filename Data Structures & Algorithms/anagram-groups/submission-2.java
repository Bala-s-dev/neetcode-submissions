class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] str = s.toCharArray();
            Arrays.sort(str);

            String key = "";
            for(int i = 0; i < str.length; i++){
                key = key + str[i];
            }
            // System.out.println(key);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                List<String> temp = new ArrayList();
                temp.add(s);
                map.put(key, temp);
            }
        }
        for(List<String> val : map.values()){
            ans.add(val);
        }
        return ans;
    }
}

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
       Map< String, List<String>> map = new HashMap<>();

       for( String word : strs){
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        String sortedword = new String(arr);
        if(!map.containsKey(sortedword)){
            map.put(sortedword, new ArrayList<>());
        }
        map.get(sortedword).add(word);
       }
       return new ArrayList<>(map.values());
    }
}

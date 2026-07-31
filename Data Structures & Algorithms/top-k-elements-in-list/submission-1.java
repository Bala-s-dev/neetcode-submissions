class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();

         for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
         }

         List<Integer>[] box = new List[nums.length + 1];

        for( int key : map.keySet()){
            int freq = map.get(key);
            if(box[freq] == null){
                box[freq] = new ArrayList<>();
            }
            box[freq].add(key);
        }
        int count = 0;
        int[] ans = new int[k];
        for(int i = nums.length ; i >= 0 && k > count ; i--){
            if(box[i]!=null){
                for(Integer value : box[i]){
                    ans[count++] = value;
                    if(count == k) break;
                }
            }
        }
        return ans;
    }
}

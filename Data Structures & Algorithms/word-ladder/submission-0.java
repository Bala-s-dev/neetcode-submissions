class Pair{
    String first;
    int second;
    
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int len = wordList.size();

        for(int i = 0; i < len; i++){
            set.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return step;
            }

            for(int i = 0; i < word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char arr[] = word.toCharArray();
                    arr[i] = c;
                    String w = new String(arr);

                    if(set.contains(w)){
                        set.remove(w);
                        q.offer(new Pair(w, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}

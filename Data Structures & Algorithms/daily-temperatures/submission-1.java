class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> stc = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {

            while(!stc.isEmpty() && 
                  temperatures[stc.peek()] < temperatures[i]) {

                int ind = stc.pop();
                result[ind] = i - ind;
            }

            stc.push(i);
        }

        return result;
    }
}
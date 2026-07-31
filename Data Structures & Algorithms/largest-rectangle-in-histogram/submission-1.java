class Solution {

    public void findpse(int[] pse, int[] heights, int n){

        Stack<Integer> stc = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!stc.isEmpty() &&
                  heights[stc.peek()] >= heights[i]){
                stc.pop();
            }

            if(stc.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = stc.peek();
            }

            stc.push(i);
        }
    }

    public void findnse(int[] nse, int[] heights, int n){

        Stack<Integer> stc = new Stack<>();

        for(int i = n - 1; i >= 0; i--){

            while(!stc.isEmpty() &&
                  heights[stc.peek()] >= heights[i]){
                stc.pop();
            }

            if(stc.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = stc.peek();
            }

            stc.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        findpse(pse, heights, n);
        findnse(nse, heights, n);

        int max = 0;

        for(int i = 0; i < n; i++){

            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            max = Math.max(max, area);
        }

        return max;
    }
}
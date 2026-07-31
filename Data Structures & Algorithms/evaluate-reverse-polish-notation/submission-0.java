class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stc = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String c = tokens[i];
            if(c.equals("+") || c.equals("-") ||
               c.equals("*") || c.equals("/")){
                int result = 0;
                int val1 = stc.pop();
                int val2 = stc.pop();
                switch(c){
                    case "+":
                        result = val2 + val1;
                        break;
                    case "-":
                        result = val2 - val1;
                        break;
                    case "*":
                        result = val2 * val1;
                        break;
                    case "/":
                        result = val2 / val1;
                        break;

                }
                stc.push(result);
            }
            else{        
                stc.push(Integer.parseInt(c));
            }
        }
        return stc.pop();
    }
}

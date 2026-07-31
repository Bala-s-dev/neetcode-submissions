class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(String s : strs){
            int len = s.length();
            str = str + len;
            str = str + '#' + s;
        }
        // System.out.println(str);
        return str;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int len = str.length();
        int l = 0;

        while(l < len){
            int r = l;
            while(str.charAt(r) != '#'){
                r++;
            }
            int w = Integer.parseInt(String.valueOf(str.substring(l, r)));
            strs.add(str.substring(r + 1, r + w + 1));
            l = r + w + 1;

        }
        return strs;
    }
}



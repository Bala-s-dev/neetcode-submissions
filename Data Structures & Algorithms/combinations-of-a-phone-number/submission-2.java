class Solution {

    List<String> data = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        data.add("");
        data.add("");
        data.add("abc");
        data.add("def");
        data.add("ghi");
        data.add("jkl");
        data.add("mno");
        data.add("pqrs");
        data.add("tuv");
        data.add("wxyz");

        List<String> ans = new ArrayList<>();
        ans.add("");

        for (char digit : digits.toCharArray()) {

            String letters = data.get(digit - '0');

            List<String> next = new ArrayList<>();

            for (String curr : ans) {
                for (char ch : letters.toCharArray()) {
                    next.add(curr + ch);
                }
            }

            ans = next;
        }

        return ans;
    }
}
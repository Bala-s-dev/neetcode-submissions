// class Solution {

//     List<String> data = new ArrayList<>();

//     public List<String> letterCombinations(String digits) {

//         if (digits.length() == 0) {
//             return new ArrayList<>();
//         }

//         data.add("");
//         data.add("");
//         data.add("abc");
//         data.add("def");
//         data.add("ghi");
//         data.add("jkl");
//         data.add("mno");
//         data.add("pqrs");
//         data.add("tuv");
//         data.add("wxyz");

//         List<String> ans = new ArrayList<>();
//         ans.add("");

//         for (char digit : digits.toCharArray()) {

//             String letters = data.get(digit - '0');

//             List<String> next = new ArrayList<>();

//             for (String curr : ans) {
//                 for (char ch : letters.toCharArray()) {
//                     next.add(curr + ch);
//                 }
//             }

//             ans = next;
//         }

//         return ans;
//     }
// }

// import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(
            digits,
            0,
            new StringBuilder(),
            result,
            phone
        );

        return result;
    }

    private void backtrack(
            String digits,
            int index,
            StringBuilder current,
            List<String> result,
            String[] phone) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters =
            phone[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char letter : letters.toCharArray()) {

            // Choose
            current.append(letter);

            // Explore
            backtrack(
                digits,
                index + 1,
                current,
                result,
                phone
            );

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}
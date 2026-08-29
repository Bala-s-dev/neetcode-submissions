

class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        // Split path using "/"
        String[] parts = path.split("/");

        for (String part : parts) {

            // Case 1: Empty part or current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Case 2: Parent directory
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Case 3: Valid directory/file name
            else {
                stack.push(part);
            }
        }

        // Build the canonical path
        StringBuilder result = new StringBuilder();

        for (String directory : stack) {
            result.append("/").append(directory);
        }

        // If stack is empty, we are at root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}
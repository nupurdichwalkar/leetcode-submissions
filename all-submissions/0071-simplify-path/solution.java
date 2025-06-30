class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] st = path.split("/");
        for(String s: st) {
            if(s.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                if(s.equals(".") || s.equals("")){
                    continue;
                } else {
                    stack.push(s);
                }
            }
        }
        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
        

        
    }
}

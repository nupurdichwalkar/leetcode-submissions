

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

class Solution {


    
    Map<Character, Boolean> seen = new HashMap<>();
    StringBuilder output = new StringBuilder();

    public String alienOrder(String[] words) {


        Map<Character, List<Character>> graph = new HashMap<>();
        for(String word: words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        List<char[]> charRelations = new ArrayList<>();
        for(int i=0; i<words.length-1; i++) {
            String currWord = words[i];
            String nextWord = words[i+1];
            if (currWord.length() > nextWord.length() && currWord.startsWith(nextWord)) {
                return "";
            }
            int len = currWord.length() > nextWord.length() ? nextWord.length() : currWord.length();
            for(int j=0; j<len;j++) {
                char c = currWord.charAt(j);
                char n = nextWord.charAt(j);
                if(c == n) continue;
                else {
                    charRelations.add(new char[]{c,n});
                    break;
                }
            }
        }
        for(int i=0; i<charRelations.size();i++){ 
            char[] ch = charRelations.get(i);
            char firstChar = ch[0];
            char secondChar = ch[1];
            if(!graph.containsKey(firstChar)){
                graph.put(firstChar, new ArrayList<>());
            }
            graph.get(firstChar).add(secondChar);
        }


        for(Character c: graph.keySet()) {
            boolean result = dfs(c, graph);
            if(!result) return "";
        }
        return output.reverse().toString();
    }

    private boolean dfs(Character c, Map<Character, List<Character>> graph ){
        if(seen.containsKey(c)) {
            return seen.get(c);
        }
        seen.put(c, false);
        for(Character next: graph.get(c)){
            boolean result = dfs(next, graph);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;

    }

}

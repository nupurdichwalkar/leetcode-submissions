

class Solution {

    class TrieNode {

        Map<Character, TrieNode> children;
        List<String> suggestions;

        TrieNode(){
            this.children = new HashMap<>();
            this.suggestions = new ArrayList<>();
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for(String product: products) {
            TrieNode node = root;
            for(char c: product.toCharArray()) {
                if(!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                node.suggestions.add(product);
                Collections.sort(node.suggestions);
                if(node.suggestions.size() > 3) {
                    node.suggestions.remove(node.suggestions.size()-1);
                }
            }
        }
        List<List<String>> answers = new ArrayList<>();
        TrieNode node = root;
        for(char c: searchWord.toCharArray()){
            if (node.children.containsKey(c)){
                node = node.children.get(c);
                answers.add(node.suggestions);
            } else {
                node.children = new HashMap<>();
                answers.add(new ArrayList<>());
            }
        }
        return answers;
    }
}

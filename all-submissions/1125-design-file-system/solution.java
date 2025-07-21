class FileSystem {

     class TrieNode {
        
        String name;
        int val = -1;
        Map<String, TrieNode> map = new HashMap<>();
        
        TrieNode (String name) {
            this.name = name;
        }
    }

    TrieNode root;
    
    public FileSystem() {
        this.root = new TrieNode("");
    }
    
    
    public boolean createPath(String path, int value) {

        String[] paths = path.split("/");

        TrieNode curr = root;

        for(int i=1;i<paths.length; i++) {
            String currComponent = paths[i];

            if(curr.map.containsKey(currComponent) == false){
                if(i == paths.length -1) {
                    curr.map.put(currComponent, new TrieNode(currComponent));
                } else {
                    return false;
                }
            }
            curr = curr.map.get(currComponent);
        }

        // Value not equal to -1 means the path already exists in the trie. 
        if (curr.val != -1) {
            return false;
        }

        curr.val = value;
        return true;
        
        
    }
    
    public int get(String path) {
        String[] paths = path.split("/");

        TrieNode curr = root;
        for(int i=1 ;i<paths.length; i++) {
            String currComponent = paths[i];
            if(!curr.map.containsKey(currComponent)){
                return -1;
            }
            curr = curr.map.get(currComponent);
        }
        return curr.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

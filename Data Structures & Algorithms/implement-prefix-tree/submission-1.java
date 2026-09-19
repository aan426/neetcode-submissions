class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children.get(c) == null){
                curr.children.put(c, new TrieNode()); //if this curr value doesn't have a child c, we map c to a new trieNode of its own 
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true; //curr will be at the last character in the word
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children.get(c) == null){
                return false;
            }
            curr = curr.children.get(c);
        }
        
        return curr.isEnd; 
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children.get(c) == null){
                return false;
            }
            curr = curr.children.get(c);
        }
        
        return true; 
    }
}

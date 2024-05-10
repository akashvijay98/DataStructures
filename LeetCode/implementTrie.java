class Trie {
  
    public Trie() {    
    }
    
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i);

            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }

            cur = cur.children.get(c);      

        }

        cur.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);

            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);

        }
        return cur.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur= cur.children.get(c);
        }
        return true;
    }

    
     static class TrieNode{
        HashMap<Character,TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
       
    }


}

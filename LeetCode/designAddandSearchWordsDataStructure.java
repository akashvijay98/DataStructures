class Node {
    HashMap<Character,Node> children = new HashMap<>();
    Boolean end=false;
}
class WordDictionary {
    Node root = new Node();
    public WordDictionary() {
       
    }
    
    public void addWord(String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new Node());
            }
            cur = cur.children.get(c);
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);        
    }

    Boolean dfs(String word,int j, Node root){
        Node cur = root;
        for(int i=j;i<word.length();i++){
            char c = word.charAt(i);

            if(c=='.'){
                for(Node child:cur.children.values() ){
                    if(dfs(word,i+1,child)) return true;
                }
                return false;
            }
            else{
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
       int ans = 0;

        ArrayList<Node>[]  heads = new ArrayList[26];

        for(int i=0;i<26;i++){
            heads[i] = new ArrayList<Node>(); 
        }

        for(String w : words){
            heads[w.charAt(0)-'a'].add(new Node(w,0));
        }

        for(char c: s.toCharArray()){
            ArrayList<Node> oldBucket = heads[c-'a'];
            heads[c-'a'] = new ArrayList<Node>();

            for(Node node : oldBucket){
                node.index++;
                if(node.index==node.word.length()){
                    ans++;
                }
                else{
                    heads[node.word.charAt(node.index)-'a'].add(node);
                }
            }

            oldBucket.clear();
        }
        return ans;

    }
}

class Node{
    String word;
    int index;
    
    public Node(String w, int i){
        word = w;
        index =i;
    }
}

package Trie;

public class Trie {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord;

        public Node(){
            for(int i=0; i< 26; i++){
                children[i]=null;
            }
        }

    }
    public static Node root = new Node();

    public static void insert(String word){

        int index =0;
        int ptr;
        int length = word.length();

        Node cur = root;

        for(ptr=0; ptr<length; ptr++){
            index = word.charAt(ptr) - 'a';

            if(cur.children[index]==null){
                cur.children[index] = new Node();
            }

            cur = cur.children[index];

        }
        cur.endOfWord = true;


    }

    public static boolean search(String word){
        int index;
        int ptr =0;
        int length = word.length();

        Node cur = root;

        for(; ptr<length; ptr++){
            index = word.charAt(ptr) - 'a';

            if(cur.children[index] == null){
                return false;
            }
            cur = cur.children[index];
        }
        return cur.endOfWord == true;

    }
    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);

            System.out.println("thee -> " + search("thee"));
            System.out.println("thor -> " + search("thor"));

        }
    }
    }

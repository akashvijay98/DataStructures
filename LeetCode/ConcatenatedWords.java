package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
    HashSet<String> set = new HashSet<>();

    List<String> result = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        for(int i=0; i<words.length; i++){
            set.add(words[i]);
        }

        for(String item : words){
            if(isConcat(item)){
                result.add(item);
            }
        }
        return result;

    }

    public boolean isConcat(String word){

        for(int i=0; i<word.length(); i++){
            String prefix = word.substring(0,i);
            String suffix = word.substring(i);

            if(set.contains(prefix) && (set.contains(suffix) || isConcat(suffix))){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args){
        String[] wordList = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        ConcatenatedWords obj = new ConcatenatedWords();
        System.out.println(obj.findAllConcatenatedWordsInADict(wordList));
    }

}

class Solution {

    /*

    Start: s = "catsanddog", start = 0  
    Memo = {}

                        (0, "catsanddog")
                        /                 \
            "cat" (3)                 "cats" (4)
            /                           \
    "sand" (7)                        "and" (7)
        |                                  |
        "dog" (10)                          "dog" (10)
        |                                   |
        [✅ Success] -> "cat sand dog"     [✅ Success] -> "cats and dog"
        
    ✅ Memo gets filled as:
    Memo[10] = [""]
    Memo[7] = ["dog"]
    Memo[3] = ["sand dog"]
    Memo[4] = ["and dog"]
    Memo[0] = ["cat sand dog", "cats and dog"]


    */

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);

        return backtrack(s,0,set,memo);
    }

    List<String> backtrack(String s,int start, Set<String> set, Map<Integer, List<String>> memo ){
        if(memo.containsKey(s)){
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if(start == s.length()){
            result.add("");
            return result;
        }

        for(int end = start+1;end<=s.length();end++){
            String word = s.substring(start, end);

            if(set.contains(word)){
                List<String> sublist = backtrack(s,end,set,memo);

                for(String sub:sublist){
                    // if all the characters in the string are matched, it will return " ", so we only add the current word to our result list
                    if(sub.isEmpty()){
                        result.add(word);
                    }
                    // if a list<String> is returned by the backtrack call then we add the result list to result list
                    else{
                        result.add(word+" "+sub);
                    }
                }
            }
        }
        // we put the resultant list of words for that particular index
        memo.put(start,result);
        return result;
    }
}

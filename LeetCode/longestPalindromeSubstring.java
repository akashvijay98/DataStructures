class Solution {
      private List<String> combinations = new ArrayList<>();
    private Map<Character, String> map = Map.of(
        '2',
        "abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
       

        if(digits.length()==0){
            return combinations;
        }
        phoneDigits = digits;
        backtrack(0,new StringBuilder());
        return combinations;



    }

    public void backtrack(int index,StringBuilder path){
        if(path.length()==phoneDigits.length()){
            combinations.add(path.toString());
            return;
        }
        String letters = map.get(phoneDigits.charAt(index));

        for(char letter: letters.toCharArray()){
            path.append(letter);
            backtrack(index+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}

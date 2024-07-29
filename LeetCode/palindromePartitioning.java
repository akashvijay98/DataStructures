class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> tempList = new ArrayList<>();
        backtrack(tempList,s,0);
        return result;
    }
    public void backtrack(List<String> tempList, String s, int startIndex){
        if(startIndex>=s.length()){
            result.add(new ArrayList<String>(tempList));
        }

        for(int end=startIndex;end<s.length();end++){
            if(isPalindrome(s,startIndex,end)){
                tempList.add(s.substring(startIndex,end+1));
                backtrack(tempList,s,end+1);
                tempList.remove(tempList.size()-1);

            }
        }

    }

    public boolean isPalindrome(String s,int left, int right){
    

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        } 
        return true;
    }
}

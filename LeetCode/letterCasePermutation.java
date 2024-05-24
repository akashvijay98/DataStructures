// link to StringBuilder chatgpt info : https://chatgpt.com/share/41bddbed-65ca-4fa0-8bf4-2a7387c8600a

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> result = new ArrayList();

        result.add(new StringBuilder());

        for(char c: s.toCharArray()){
            
            int n= result.size();

            if(Character.isLetter(c)){

                for(int i=0;i<n;i++){
                    result.add(new StringBuilder(result.get(i)));
                    result.get(i).append(Character.toLowerCase(c));
                    result.get(i+n).append(Character.toUpperCase(c));
                }
            }
            else{
                for(int i=0;i<n;i++){
                    result.get(i).append(c);
                }
            }
        }

        List<String> ans = new ArrayList<>();

        for(StringBuilder sb: result){
            ans.add(sb.toString());

        }

        return ans;

    }

}

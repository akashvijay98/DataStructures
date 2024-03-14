class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] matches = new int[n];
        Arrays.fill(matches,-1);
        for(int i=0; i< indices.length ;i++){
            int idx = indices[i];
            if(idx+sources[i].length()-1 < n){
                if(s.substring(idx,idx + sources[i].length()).equals(sources[i])){
                        matches[idx]=i;
                }

            }
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < n){
            if(matches[index]>=0){
                sb.append(targets[matches[index]]);
                index += sources[matches[index]].length();
            }
            else{
                sb.append(s.charAt(index++));
            }    

        }

        return sb.toString();


    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        //store the last index of every char in the map

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start =0, end=0;
        // for every i, check which is the maximum end until now, if i == maxEnd, it means that is the parition
        for(int i=0;i<s.length();i++){
            end= Math.max(end, map.get(s.charAt(i)));

            if(end == i){
                list.add(end-start+1);
                start = end+1;
            }
        }

        return list;
    }
}

class Solution {

    /*

        Approach: 1. map email to email

        e.g [akash, a, b, c]
            [akash, c, d, e]

            map{a:[b,c], c:[d,e]}

                    a -> [b, c]
                             |
                             [d, e]

        2. map mail to name
            e.g map: {a:akash, b: akash, c:akash ..... e:akash}

        
        3. perform dfs from (a) to find all connecting nodes and add them  to the list

            list = [a,b,c,d,e]


    */


    HashSet<String> set = new HashSet<>(); 
    HashMap<String,List<String>> map = new HashMap<>();
    HashMap<String,String> emailToName = new  HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      
       

        List<List<String>> result = new ArrayList<>();

        for(List<String> acc : accounts){
            String firstEmail = acc.get(1);
            String name = acc.get(0);

            emailToName.put(firstEmail,name);

            for(int i = 1;i<acc.size();i++){
                String curEmail = acc.get(i); 

              
                map.computeIfAbsent(firstEmail,  x -> new ArrayList<>()).add(curEmail);
                map.computeIfAbsent(curEmail, x -> new ArrayList<>()).add(firstEmail);
                 

                emailToName.put(curEmail, name);
            }
        }

        for(String key: map.keySet()){
           
            if(!set.contains(key)){
                List<String> con = new ArrayList<>();

                dfs(key,con);
                Collections.sort(con);
                con.add(0,emailToName.get(key));

                result.add(con);
            } 
            

        }
        return result;
    }

    private void dfs(String node, List<String> list){
        set.add(node);
        list.add(node);

        for(String nei : map.get(node)){
            if(!set.contains(nei)){
                dfs(nei,list);
            }
            
        }

    }
}

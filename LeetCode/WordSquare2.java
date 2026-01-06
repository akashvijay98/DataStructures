class Solution {
    public List<List<String>> wordSquares(String[] words) {
        int n = words.length;
        List<List<String>> result = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            String top = words[i];

            for(int j =0;j<n;j++){
                if(i==j){
                    continue;
                }

                String left = words[j];

                if(top.charAt(0) != left.charAt(0)){
                    continue;
                }


                for(int k=0;k<n;k++){
                    if(k==i || k==j){
                        continue;
                    }

                    String right = words[k];

                    if (top.charAt(3) != right.charAt(0)) continue;
                

                    for(int l=0;l<n;l++){
                        if(l==i || l==k || l==j){
                            continue;
                        }
                        String bottom = words[l];

                        if (bottom.charAt(0) == left.charAt(3) && 
                                bottom.charAt(3) == right.charAt(3)) {
                                
                                // All constraints met, add to result
                                List<String> validSquare = new ArrayList<>();
                                validSquare.add(top);
                                validSquare.add(left);
                                validSquare.add(right);
                                validSquare.add(bottom);
                                result.add(validSquare);
                            }
                    }
                }
            }

            
            
        }   

        Collections.sort(result, (a,b)->{
        for (int x = 0; x < 4; x++) {
            if (!a.get(x).equals(b.get(x))) {
                    return a.get(x).compareTo(b.get(x));
            }
        }
        return 0;
        
        });

        return result;
    }
}

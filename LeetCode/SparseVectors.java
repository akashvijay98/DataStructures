// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.io.*;
import java.util.*;
class SparseVector {
    Map<Integer,Integer> map = new HashMap<>();
    
    // we only multiply non zero elements
    // hence we first mark the positions of nonzero elements in the Array using map
    SparseVector(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                map.put(i,nums[i]);
            }
        }
    }
    
    public int dotProduct(SparseVector vec){
        int dotProduct =0;
        // we match positions of non zero elements from current object with object from the method paramter. 
        // if both position matches, that means there exists non zero elements in both object's maps in that index
        for(Integer key : map.keySet()){
            if(vec.map.containsKey(key)){
                dotProduct = dotProduct + map.get(key) * vec.map.get(key);
            }
        }
        
        return dotProduct;
    }
    
    public static void main(String[] args) {
       SparseVector v1 = new SparseVector(new int[]{1,0,0,2,3});
       SparseVector v2 = new SparseVector(new int[]{0,3,0,4,0});
       
       System.out.println("result: " +v1.dotProduct(v2));
    }
}

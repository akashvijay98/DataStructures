class FirstUnique {
    HashMap<Integer,Boolean> map;
    Set<Integer> set;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
    
        map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        if(!set.isEmpty()){
            return set.iterator().next();
        }
        return -1;
    }
    
    public void add(int value) {
       if(!map.containsKey(value)){
            map.put(value, true);
            set.add(value);
       }
       else if(map.get(value)){
        map.put(value,false);
        set.remove(value);
       }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

import java.util.LinkedList;

public class CustomHashMap<K,V>{
    private static class Entry<K,V>{
        K key;
        V value;
        
        Entry(K key, V value){
            this.key = key;
            this.value= value;
        }
    }
    
    private static int CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    
    
    public CustomHashMap(){
        buckets = new LinkedList[CAPACITY];
    }
    
    private int hash(K key){
        return (key == null)?0 : Math.abs(key.hashCode() % buckets.length);
    }
    public void put(K key, V value){
        int index = hash(key);
        
        // we check if the key already exists in the bucket
        if(buckets[index]==null){
            buckets[index] = new LinkedList<>();
        }
        for(Entry<K,V> entry: buckets[index]){
            //if key already mapped to value, overwrite
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key,value));
        size++;
        
        if((float)size/buckets.length > LOAD_FACTOR){
           System.out.println("limit exceeded");
        }
    }
    public V get(K key){
        int index = hash(key);
        if(buckets[index]!=null){
            for(Entry<K,V> entry: buckets[index]){
                if(entry.key.equals(key)){
                    return entry.value;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println(map.get("one"));
        System.out.println(map.get("two"));
	}
}




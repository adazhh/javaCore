package algorithm.wordProblems;

import java.util.HashMap;

public class W01RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool(){
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }
        public void insert(K key){
            if (!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }
        public void delete(K key){
            if (keyIndexMap.containsKey(key)){
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }
        public K getRandom(){
            if (size == 0){
                return null;
            }
            int randomIndex = (int)(Math.random() * this.size);
            return this.indexKeyMap.get(randomIndex);
        }
    }
}

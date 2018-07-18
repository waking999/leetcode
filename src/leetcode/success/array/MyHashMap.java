package leetcode.success.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashmap/description/
 *
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class MyHashMap {

    private final static int IMPOSSIBLE_VALUE=-1;
    int[] keySet;
    int[] valSet;
    int count;
    private static final float expandRate=0.9F;
    private static final int initialSize=1000;

    /** Initialize your data structure here. */
    public MyHashMap() {
        keySet=new int[initialSize];
        Arrays.fill(keySet,IMPOSSIBLE_VALUE);
        valSet=new int[initialSize];
        Arrays.fill(valSet,IMPOSSIBLE_VALUE);
        count=0;
    }

    private void expand(){
        int size=keySet.length;
        if(count>=size*expandRate){
            int[] newKeySet=new int[size+initialSize];
            Arrays.fill(newKeySet,IMPOSSIBLE_VALUE);
            System.arraycopy(keySet, 0, newKeySet, 0, count);
            keySet=newKeySet;

            int[] newValSet=new int[size+initialSize];
            Arrays.fill(newValSet,IMPOSSIBLE_VALUE);
            System.arraycopy(valSet, 0, newValSet, 0, count);
            valSet=newValSet;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int keyPos=findKeyPos(key);
        if(keyPos==IMPOSSIBLE_VALUE){
            expand();

            keySet[count]=key;
            valSet[count]=value;
            count++;
        }else {
            valSet[keyPos]=value;
        }


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int keyPos=findKeyPos(key);
        if(keyPos==IMPOSSIBLE_VALUE){
            return IMPOSSIBLE_VALUE;
        }
        return valSet[keyPos];
    }
    private int findKeyPos(int key){
        for(int i=0;i<count;i++){
            if(keySet[i]==key){
                return i;
            }
        }
        return IMPOSSIBLE_VALUE;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int keyPos=findKeyPos(key);
        if(keyPos==IMPOSSIBLE_VALUE){
            return;
        }
        moveToLeft(keySet,keyPos);
        moveToLeft(valSet,keyPos);
        count--;
    }

    private void moveToLeft(int[] array,int from){
        for(int i=from;i<=count-1;i++){
            array[i]=array[i+1];
        }
    }
}

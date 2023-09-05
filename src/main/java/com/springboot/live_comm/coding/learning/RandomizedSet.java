package com.springboot.live_comm.coding.learning;

import java.util.*;

class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);

        randomizedSet.remove(0);

        randomizedSet.insert(0);

//        System.out.println(randomizedSet.getRandom());
    }

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            int index = list.size();
            list.add(val);
            map.put(val, index);
            return true;
        }
    }





    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer index = map.get(val);
            int lastIndex = list.size() - 1;
            Integer integer1 = list.get(lastIndex);
            list.set(index, integer1);
            map.put(integer1, index);
            map.remove(val);
            list.remove(lastIndex);
            return true;
//            int index = map.get(val);
//            int last = list.get(list.size() - 1);
//            list.set(index, last);
//            map.put(last, index);
//            list.remove(list.size() - 1);
//            map.remove(val);
//            return true;

        } else {
            return false;
        }
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
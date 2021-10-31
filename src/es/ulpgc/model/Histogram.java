package es.ulpgc.model;

import java.util.HashMap;
import java.util.Set;

public class Histogram<T> {

    private HashMap<T, Integer> histogram = new HashMap<>();

    public Integer get(T key) {
        return histogram.get(key);
    }

    public void increment(T object) {
        histogram.put(object, histogram.containsKey(object) ? histogram.get(object) + 1 : 1);
    }

    public Set<T> keySet() {
        return histogram.keySet();
    }

}
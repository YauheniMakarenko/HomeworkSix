package com.lesson.HomeworkEight.SortStrategy;

import java.util.HashMap;
import java.util.Map;

public class AllSortStrategy {
    private Map<Integer, SortStrategy> mapSort;

    public AllSortStrategy() {
        this.mapSort = new HashMap<>();
        mapSort.put(1, new SortTopByPrice());
        mapSort.put(2, new SortTopByMaxSpeed());
    }

    public Map<Integer, SortStrategy> getMapSort() {
        return mapSort;
    }
}

package com.lesson.HomeworkEight.StrategySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AllSearchStrategies {
    Map<Integer, SearchStrategy> map;

    public AllSearchStrategies(){
        this.map = new HashMap<>();
        map.put(1, new SearchByPrice());
        map.put(2, new SearchByYearOfManufacture());
        map.put(3, new SearchByProduccer());
        map.put(4, new SearchByTwoParamerts());
    }

    public Map<Integer, SearchStrategy> getMap() {
        return map;
    }
}

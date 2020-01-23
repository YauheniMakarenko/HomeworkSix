package com.lesson.HomeworkEight.SortStrategy;

import com.lesson.HomeworkEight.Car;

import java.util.List;
import java.util.Map;

public interface SortStrategy {
    List<Map.Entry<Car, Integer>> sortTop();
}

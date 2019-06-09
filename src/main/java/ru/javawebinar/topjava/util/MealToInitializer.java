package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MealToInitializer {
    public static List<MealTo> initialise() {
        List<MealTo> meals = new ArrayList<>();
        meals.add(new MealTo(LocalDateTime.of(2019, 4, 3, 13, 25), "launch", 2517, true));
        meals.add(new MealTo(LocalDateTime.of(2019, 4, 3, 19, 15), "snake", 500, false));
        meals.add(new MealTo(LocalDateTime.of(2019, 4, 4, 7, 5), "breakfast", 925, false));

        return meals;

    }
}

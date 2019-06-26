package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTestData {


    public static final Meal MEAL1 = new Meal(1, LocalDateTime.of(2019, 6, 22, 10, 2, 23), "Breakfast", 530);
    public static final Meal MEAL2 = new Meal(LocalDateTime.of(2019, 6, 22, 14, 5, 35), "Lunch", 940);
    public static final Meal MEAL3 = new Meal(LocalDateTime.of(2019, 6, 22, 19, 34), "Snake", 340);

    public static final Meal MEAL4 = new Meal(LocalDateTime.of(2019, 6, 23, 7, 15), "Breakfast 2 eggs++", 590);
    public static final Meal MEAL5 = new Meal(LocalDateTime.of(2019, 6, 23, 15, 1, 25), "Lunch Beans + Meat", 1200);
    public static final Meal MEAL6 = new Meal(LocalDateTime.of(2019, 6, 23, 21, 7, 56), "Snake light", 290);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualTo(expected);
    }


}

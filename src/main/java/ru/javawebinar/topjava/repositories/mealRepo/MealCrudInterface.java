package ru.javawebinar.topjava.repositories.mealRepo;

import ru.javawebinar.topjava.model.Meal;

public interface MealCrudInterface {
    void create(Meal meal);

    void read();

    void update(Meal meal);

    void delete(long id);
}

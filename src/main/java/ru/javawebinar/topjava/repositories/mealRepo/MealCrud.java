package ru.javawebinar.topjava.repositories.mealRepo;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealInitializer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.slf4j.LoggerFactory.getLogger;

public class MealCrud implements MealCrudInterface {
    private static final Logger log = getLogger(MealCrud.class);
    private static boolean isInitialised = false;
    private static Map<Long, Meal> mealMap = new ConcurrentHashMap<>();
    private static volatile long counter = 0;

    public static void initialise() {
        if (!isInitialised) {
            //initialise collection
            List<Meal> listOfMeal = MealInitializer.getMeals();
            for (Meal m : listOfMeal) {
                mealMap.put(m.getId(), m);
            }
        }
        isInitialised = true;


    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        MealCrud.counter = counter;
    }

    public static Map<Long, Meal> getMealMap() {
        return mealMap;
    }

    @Override
    public void create(Meal meal) {
        log.debug("CRUD - create");
        mealMap.put(meal.getId(), meal);
        mealMap.forEach((k, v) -> System.out.println(k + " " + v.toString()));
    }

    @Override
    public void read() {

    }

    @Override
    public void update(Meal meal) {
        mealMap.put(meal.getId(), meal);
    }

    @Override
    public void delete(long id) {
        mealMap.remove(id);
        counter = mealMap.size();
    }
}

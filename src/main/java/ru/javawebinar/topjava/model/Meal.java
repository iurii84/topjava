package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.repositories.mealRepo.MealCrud;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {
    private LocalDateTime dateTime;
    private String description;
    private int calories;
    private final long id;


    public Meal(LocalDateTime dateTime, String description, int calories) {
        this.id = MealCrud.getCounter() + 1;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        MealCrud.setCounter(this.id);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }


    @Override
    public String toString() {
        return "Meal{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", id=" + id +
                '}';
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
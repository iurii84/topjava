package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repositories.mealRepo.MealCrud;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    public void init(ServletConfig servletConfig) {
        log.debug("init");
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        MealCrud.initialise();
        MealCrud mealCrud = new MealCrud();
        mealCrud.create(new Meal(LocalDateTime.of(2000, 1, 1, 12, 0), "test", 0));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Enter into doGet method of MealServlet");

        Map<Long, Meal> mealMap = MealCrud.getMealMap();

        List<Meal> listOfMeals = new ArrayList<>();
        mealMap.forEach((k, v) -> listOfMeals.add(v));

        List<MealTo> mealsWithExcess = MealsUtil.getFilteredWithExcess(listOfMeals, LocalTime.MIN, LocalTime.MAX, 2000);
        System.out.println(mealsWithExcess);

        request.setAttribute("mealList", mealsWithExcess);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}

package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repositories.mealRepo.MealCrud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class UpdateMealServlet extends HttpServlet {
    private static final Logger log = getLogger(UpdateMealServlet.class);

    private volatile Meal actualMeal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("UpdateMealServlet - GET");
        actualMeal = MealCrud.getMealMap().get(Long.parseLong(req.getParameter("id")));

        log.debug("Actual meal for editing purpose was created");
        req.setAttribute("actualMeal", actualMeal);
        req.getRequestDispatcher("/updateMeal.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        log.debug("UpdateMeal Servlet - doPost");

        LocalDate localDate = LocalDate.parse(req.getParameter("date"));
        LocalTime localTime = LocalTime.parse(req.getParameter("time"));
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        String description = req.getParameter("description");
        int calories = Integer.parseInt(req.getParameter("calories"));

        synchronized (this) {
            Meal updatedMeal = actualMeal;
            updatedMeal.setDateTime(localDateTime);
            updatedMeal.setDescription(description);
            updatedMeal.setCalories(calories);

            log.debug("updated Meal created");

            MealCrud mealCrud = new MealCrud();
            mealCrud.update(updatedMeal);
        }

        resp.sendRedirect("meals");
        log.debug("Meal updated in DB");


    }
}

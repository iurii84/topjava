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

public class NewMealServlet extends HttpServlet {
    private static final Logger log = getLogger(NewMealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("NewMealServlet - doGet");
        req.getRequestDispatcher("/newMeal.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.debug("NewMealServlet - doPost");


        LocalDate date = LocalDate.parse(req.getParameter("date"));
        LocalTime time = LocalTime.parse(req.getParameter("time"));
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        synchronized (this) {
            Meal meal = new Meal(dateTime,
                    req.getParameter("description"),
                    Integer.parseInt(req.getParameter("calories")));

            log.debug("New meal created");

            MealCrud mealCrud = new MealCrud();
            mealCrud.create(meal);
        }

        log.debug("New meal sended to CRUD");

        resp.sendRedirect("meals");
    }


}

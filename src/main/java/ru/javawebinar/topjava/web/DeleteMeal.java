package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.repositories.mealRepo.MealCrud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class DeleteMeal extends HttpServlet {
    private static final Logger log = getLogger(DeleteMeal.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("deleteMeal - doPost");
        MealCrud mealCrud = new MealCrud();
        mealCrud.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("meals");
    }
}

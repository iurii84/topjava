package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class JspMealController {
private MealService mealService;
private static final Logger log = getLogger(JspMealController.class);
    @Autowired
    JspMealController(MealService mealService){
        this.mealService = mealService;
    }
    private int userId = SecurityUtil.authUserId();

    @GetMapping("/meals")
    public String getAllMeals(Model model) {
        log.info("getAll for user {}", userId);
        model.addAttribute("meals",  MealsUtil.getWithExcess(mealService.getAll(userId), SecurityUtil.authUserCaloriesPerDay()));
        return "meals";
    }
}

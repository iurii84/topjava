package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;

@Controller
public class JspMealController {
    private MealService mealService;
    private static final Logger log = getLogger(JspMealController.class);

    @Autowired
    JspMealController(MealService mealService) {
        this.mealService = mealService;
    }


    @GetMapping("/meals")
    public String getAllMeals(Model model) {
        log.info("getAll for user {}", SecurityUtil.authUserId());
        model.addAttribute("meals", MealsUtil.getWithExcess(mealService.getAll(SecurityUtil.authUserId()), SecurityUtil.authUserCaloriesPerDay()));
        return "meals";
    }

    @GetMapping("meals/add")
    public String newMealTable() {
        return "mealForm";
    }

    @PostMapping("meals/add")
    public String addNewMeal(HttpServletRequest request) {
        Meal meal = new Meal(
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        if (StringUtils.isEmpty(request.getParameter("id"))) {
            log.warn("id id empty - then create new meal");
            mealService.create(meal, SecurityUtil.authUserId());
        } else {
            log.warn("id is NOT empty - then update meal");
            assureIdConsistent(meal, getId(request));
            mealService.update(meal, SecurityUtil.authUserId());
        }
        return "redirect:/meals";
    }

    @GetMapping("meals/update")
    public String updateMeal(HttpServletRequest request) {
        int id = getId(request);
        int userId = SecurityUtil.authUserId();
        Meal meal = mealService.get(id, userId);
        System.out.println(meal.getUser().getId());
        request.setAttribute("meal", meal);
        return "mealForm";
    }


    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}

package ru.javawebinar.topjava.web.meal;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = MealRestController.REST_MEAL_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController extends AbstractMealController {

    static final String REST_MEAL_URL = "/rest/meals";

    @GetMapping
    public List<MealTo> getAllMeal() {
        log.info("getAllMeal");
        return super.getAll();
    }

    @GetMapping("/{id}")
    public Meal getMeal(@PathVariable int id) {
        log.info("get Meal {}", id );
        return super.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createMeal(@NotNull @RequestBody Meal meal) throws URISyntaxException {
        meal.setDateTime(LocalDateTime.now());
        System.out.println(meal.toString());
        log.info("create {}", meal);
        checkNew(meal);
        Meal created = super.create(meal);
        if (created == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            URI uriOfNewResource = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path(REST_MEAL_URL + "/{id}")
                    .buildAndExpand(created.getId()).toUri();
            return ResponseEntity.created(uriOfNewResource).body(created);
        }

    }

}
package ru.javawebinar.topjava.web.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ru.javawebinar.topjava.web.AbstractMealControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.topjava.MealTestData.*;


class MealRestControllerTest extends AbstractMealControllerTest {
    static final String REST_MEAL_URL = MealRestController.REST_MEAL_URL + '/';

    @Test
    void getAllMeal() throws Exception {
        mockMvc.perform(get(REST_MEAL_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
               // .andExpect(contentJson(MEALS))
        ;

    }

    @Test
    void getMeal() {
    }

    @Test
    void createMeal() {
    }

    @Test
    void deleteMeal() {
    }

    @Test
    void updateMeal() {
    }

    @Test
    void getBetween() {
    }
}
package ru.javawebinar.topjava.web.meal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by nonu on 10/18/2016.
 */
@RestController
@RequestMapping("/ajax/meals")
public class UserMealAjaxController extends AbstractUserMealController {
    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                               @RequestParam("description") String description,
                               @RequestParam("calories") int calories) {

        UserMeal meal = new UserMeal(dateTime, description, calories);
        super.create(meal);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getAll() {
        return super.getAll();
    }
}
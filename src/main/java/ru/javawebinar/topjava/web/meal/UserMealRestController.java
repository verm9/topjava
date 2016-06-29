package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {

    @Autowired
    private UserMealService service;

    public UserMeal get(int id) {
        return service.get(id, LoggedUser.getUser());
    }

    public void delete(int id) { service.delete(id, LoggedUser.getUser()); }

    public void getAll() { service.getAll(LoggedUser.getUser()); }

}

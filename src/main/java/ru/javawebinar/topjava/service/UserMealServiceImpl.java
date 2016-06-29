package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;

import java.util.List;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal save(UserMeal userMeal, User user) {
        return ExceptionUtil.checkNotFoundWithId( repository.save(userMeal, user), userMeal.getId() );
    }

    @Override
    public void delete(int id, User user) {
        ExceptionUtil.checkNotFoundWithId( repository.delete(id, user), id );
    }

    @Override
    public UserMeal get(int id, User user) {
        return ExceptionUtil.checkNotFoundWithId( repository.get(id, user), id );
    }

    @Override
    public List<UserMeal> getAll(User user) {
        return repository.getAll(user);
    }
}

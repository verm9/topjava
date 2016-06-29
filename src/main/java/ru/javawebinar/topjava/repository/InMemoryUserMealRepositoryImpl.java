package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */
@Repository
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(userMeal -> save(userMeal, new User()));
    }

    @Override
    public UserMeal save(UserMeal userMeal, User user) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        userMeal.setOwner(user);
        repository.put(userMeal.getId(), userMeal);
        return userMeal;
    }

    @Override
    public boolean delete(int id, User user) {
        UserMeal toBeDeleted = this.get(id, user);
        if (toBeDeleted != null) {
            repository.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public UserMeal get(int id, User user)
    {
        UserMeal result = repository.get(id);
        if (result.getOwner().equals(user))
            return repository.get(id);
        return null;
    }

    @Override
    public List<UserMeal> getAll(User user) {
        return repository.values()
                .stream()
                .filter(userMeal -> userMeal.getOwner().equals(user))
                .collect(Collectors.toList());
    }
}


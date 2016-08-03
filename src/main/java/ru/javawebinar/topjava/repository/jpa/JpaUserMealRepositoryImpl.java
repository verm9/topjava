package ru.javawebinar.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
public class JpaUserMealRepositoryImpl implements UserMealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {
        User user = em.getReference(User.class, userId);
        userMeal.setUser(user);
        if (userMeal.isNew()) {
            em.persist(userMeal);
        } else {
            if (get(userMeal.getId(), userId) == null)
                return null;
            em.merge(userMeal);
        }
        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return em.createNamedQuery(UserMeal.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> resultList = em.createNamedQuery(UserMeal.OF_CURRENT_USER, UserMeal.class).setParameter("userId", userId).setParameter("id", id).getResultList();
        return resultList.size() == 0 ? null : DataAccessUtils.requiredSingleResult(resultList);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return em.createNamedQuery(UserMeal.GET_ALL, UserMeal.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createNamedQuery(UserMeal.GET_BETWEEN, UserMeal.class)
                .setParameter("userId", userId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate).getResultList();
    }
}
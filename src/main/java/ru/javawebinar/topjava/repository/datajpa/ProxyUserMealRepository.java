package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 27.03.2015.
 */
@Transactional(readOnly = true)
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {

    @Transactional
    @Modifying
//    @Query(name = UserMeal.DELETE)
    @Query("DELETE FROM UserMeal u WHERE u.id=:id AND u.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional
    UserMeal save(UserMeal UserMeal);

    @Query("SELECT u FROM UserMeal u WHERE u.id=:id AND u.user.id=:userId")
    UserMeal get(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT u FROM UserMeal u WHERE u.user.id=:userId ORDER BY u.dateTime DESC")
    List<UserMeal> getAll(@Param("userId") int userId);

    @Query("SELECT m FROM UserMeal m "+
            "WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC")
    List<UserMeal> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate,
                              @Param("userId") int userId);

}

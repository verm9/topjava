package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.JDBC;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

/**
 * Created by nonu on 8/10/2016.
 */
@ActiveProfiles({POSTGRES, DATAJPA})
public class DataJpaUserMealServiceTest extends UserMealServiceTest {
}

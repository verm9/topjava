package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.*;

/**
 * Created by nonu on 8/10/2016.
 */
@ActiveProfiles({POSTGRES, JPA})
public class JpaUserServiceTest extends UserServiceTest {
}

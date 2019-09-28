package win.ots.hello.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.ots.hello.Application;
import win.ots.hello.entity.User;
import win.ots.hello.service.UserService;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
    }

    @Test
    public void get() {

        User user = userService.findById(1L);
        log.info("user:" + user);

    }

    @Test
    public void findByUserName() {
        String userName = "user_1";
        User user = userService.findByUserName(userName);

        log.info("user:" + user);

        assertEquals(userName, user.getUserName());


    }

    @Test
    public void getRoleByUserId() {
        Long userId = 1L;
        Set<String> roles = userService.getRoleByUserId(userId);

        log.info(roles.toString());

    }
}
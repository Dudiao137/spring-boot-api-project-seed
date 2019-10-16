package com.conpany.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.project.Application;
import com.company.project.v1.entity.User;
import com.company.project.v1.mapper.UserMapper;
import com.company.project.v1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SimpleTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    private User user;

    @Before
    public void init() {
        Date now = new Date();
        user = new User();
        user.setUserName(now.toString());
        user.setPassword("123456");
        user.setNickName("otswang");
        user.setSalt("xxxxxxxx");
        user.setRegisterDate(now);
    }

    @Test
    public void testMapperInsert() {
        int count = userMapper.insert(user);

        log.info("count: {}, user:{}", count, user);

    }

    @Test
    public void testServiceSave() {
        boolean result = userService.save(user);
        log.info("save user: {} , ok ? {}", user, result);
    }

    @Test
    public void testMapperSelect() {
        Map<String, Object> query = new HashMap<>();
        query.put("nick_name", "otswang");
        List<User> users = userMapper.selectByMap(query);

        log.info("user list: {}", users);
    }

    @Test
    public void testSelect02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "otswang");
        List<User> users = userMapper.selectList(queryWrapper);
        log.info("users: {}", users);
    }

    @Test
    public void testSelect() {
        User user = userMapper.findByName("otswang");
        log.info("user: {}", user);
    }

    @Test
    public void testSelect2() {
        User user = userMapper.findByName2("otswang");
        log.info("user: {}", user);
    }

    @Test
    public void testWrapperDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick_name", "otswang");
        int delete = userMapper.delete(queryWrapper);
        log.info("delete count: {}", delete);
    }

}

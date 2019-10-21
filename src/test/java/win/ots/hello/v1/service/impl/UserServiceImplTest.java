package win.ots.hello.v1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import win.ots.hello.SimpleTest;
import win.ots.hello.v1.service.IUserService;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@Slf4j
public class UserServiceImplTest extends SimpleTest {

    @Autowired
    private IUserService userService;

    @Test
    public void getRolesByUserId() {
        Long userId = 1L;
        Set<String> roles = userService.getRolesByUserId(userId);
        log.info("roles: {}", roles);
    }
}
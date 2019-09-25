package win.ots.hello.service;

import win.ots.hello.entity.User;

import java.util.List;

/**
 * @author: sy.wang
 * @date: 20190926
 */
public interface UserService {

    List<User> findAll();

    User get(Long userId);


}

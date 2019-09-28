package win.ots.hello.service;

import win.ots.hello.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author: sy.wang
 * @date: 20190926
 */
public interface UserService {

    List<User> findAll();

    User findById(Long userId);

    User findByUserName(String userName);

    Set<String> getRoleByUserId(Long userId);


}

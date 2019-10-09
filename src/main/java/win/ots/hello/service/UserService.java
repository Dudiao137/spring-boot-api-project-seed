package win.ots.hello.service;

import win.ots.hello.entity.User;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
public interface UserService {

    User get(String id);

    List<User> findList(User user);

    List<User> findAllList();

    int insert(User user);

    int insertBatch(List<User> users);

    int update(User user);

    int delete(User user);

}

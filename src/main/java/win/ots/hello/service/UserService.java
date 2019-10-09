package win.ots.hello.service;

import win.ots.hello.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Author: sy.wang
 * Date: 20191009
 */
public interface UserService {

    User get(int id);

    List<User> findList(User user);

    List<User> findAllList();

    int insert(User user);

    int insertBatch(List<User> users);

    int update(User user);

    int delete(User user);

    Set<String> getRolesByUserId(int userId);

    User getByUserName(String userName);
}

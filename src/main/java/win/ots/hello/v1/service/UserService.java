package win.ots.hello.v1.service;

import win.ots.hello.v1.entity.User;

import java.util.List;

/**
 * Author sy.wang
 * Date  2019-09-29
 */
public interface UserService {

    public User get(String id);

    public List<User> findList(User user);

    public List<User> findAllList();

    public int insert(User user);

    public int insertBatch(List<User> users);

    public int update(User user);

    public int delete(User user);

}

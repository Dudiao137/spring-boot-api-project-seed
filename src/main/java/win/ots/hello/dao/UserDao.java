package win.ots.hello.dao;

import win.ots.hello.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Repository
public interface UserDao {

    User get(int id);

    User getByUserName(String userName);

    List<User> findList(User user);

    List<User> findAllList();

    int insert(User user);

    int insertBatch(List<User> users);

    int update(User user);

    int delete(User user);

}
package win.ots.hello.dao;

import win.ots.hello.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Repository
public interface RoleDao {

    Role get(int id);

    List<Role> findList(Role role);

    List<Role> findAllList();

    int insert(Role role);

    int insertBatch(List<Role> roles);

    int update(Role role);

    int delete(Role role);

}
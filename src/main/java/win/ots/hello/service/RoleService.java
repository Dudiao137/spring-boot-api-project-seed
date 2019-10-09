package win.ots.hello.service;

import win.ots.hello.entity.Role;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
public interface RoleService {

    Role get(int id);

    List<Role> findList(Role role);

    List<Role> findAllList();

    int insert(Role role);

    int insertBatch(List<Role> roles);

    int update(Role role);

    int delete(Role role);

}

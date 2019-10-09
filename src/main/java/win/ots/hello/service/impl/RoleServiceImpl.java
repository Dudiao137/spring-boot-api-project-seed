package win.ots.hello.service.impl;

import win.ots.hello.dao.RoleDao;
import win.ots.hello.entity.Role;
import win.ots.hello.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    
    @Override
    public Role get(int id){
        return roleDao.get(id);
    }
    
    @Override
    public List<Role> findList(Role role) {
        return roleDao.findList(role);
    }
    
    @Override
    public List<Role> findAllList() {
        return roleDao.findAllList();
    }
    
    @Override
    public int insert(Role role) {
        return roleDao.insert(role);
    }
    
    @Override
    public int insertBatch(List<Role> roles){
        return roleDao.insertBatch(roles);
    }
    
    @Override
    public int update(Role role) {
        return roleDao.update(role);
    }
    
    @Override
    public int delete(Role role) {
        return roleDao.delete(role);
    }

}

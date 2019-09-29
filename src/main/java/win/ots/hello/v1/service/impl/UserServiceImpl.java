package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.dao.UserDao;
import win.ots.hello.v1.entity.User;
import win.ots.hello.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author sy.wang
 * Date  2019-09-29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public User get(String id){
        return userDao.get(id);
    }
    
    @Override
    public List<User> findList(User user) {
        return userDao.findList(user);
    }
    
    @Override
    public List<User> findAllList() {
        return userDao.findAllList();
    }
    
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }
    
    @Override
    public int insertBatch(List<User> users){
        return userDao.insertBatch(users);
    }
    
    @Override
    public int update(User user) {
        return userDao.update(user);
    }
    
    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

}

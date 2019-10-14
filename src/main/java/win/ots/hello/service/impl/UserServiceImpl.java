package win.ots.hello.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import sun.security.provider.MD5;
import win.ots.hello.dao.RoleDao;
import win.ots.hello.dao.UserDao;
import win.ots.hello.dao.UserRoleRelationDao;
import win.ots.hello.entity.Role;
import win.ots.hello.entity.User;
import win.ots.hello.entity.UserRoleRelation;
import win.ots.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleRelationDao userRoleRelationDao;

    
    @Override
    public User get(int id){
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
        assert user != null;
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = user.getPassword();
//        password = new Md5Hash(password, salt, 2).toString();
        password = DigestUtils.md5Hex(password);
        user.setPassword(password);
        user.setSalt(salt);
        user.setRegisterDate(new Date());
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

    @Override
    public Set<String> getRolesByUserId(int userId) {
        Set<String> roles = new HashSet<>();
        UserRoleRelation userRoleRelation = new UserRoleRelation();
        userRoleRelation.setUserId(userId);
        List<UserRoleRelation> userRoleRelations = userRoleRelationDao.findList(userRoleRelation);
        if (CollectionUtils.isNotEmpty(userRoleRelations)) {
            userRoleRelations.forEach((item) -> {
                Optional<Role> optionalRole = Optional.ofNullable(roleDao.get(item.getRoleId()));
                optionalRole.ifPresent((role -> roles.add(role.getRole())));
            });
        }

        return roles;
    }

    @Override
    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }
}

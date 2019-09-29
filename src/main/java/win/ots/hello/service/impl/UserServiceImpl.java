package win.ots.hello.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.ots.hello.constant.ErrorCode;
import win.ots.hello.constant.ShiroConstant;
import win.ots.hello.core.exception.ServiceException;
import win.ots.hello.dao.RoleRepository;
import win.ots.hello.dao.UserRepository;
import win.ots.hello.dao.UserRoleRelationRepository;
import win.ots.hello.entity.User;
import win.ots.hello.entity.UserRoleRelation;
import win.ots.hello.service.UserService;
import win.ots.hello.web.vo.UserCreateVo;
import win.ots.hello.web.vo.UserInfoVo;

import java.util.*;

/**
 * @author: sy.wang
 * @date: 20190926
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRelationRepository userRoleRelationRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }


    @Override
    public Set<String> getRoleByUserId(Long userId) {
        Set<String> roleNames = new HashSet<>();
        List<UserRoleRelation> userRoleRelations = userRoleRelationRepository.getAllByUserId(userId);
        if (CollectionUtils.isNotEmpty(userRoleRelations)) {
            userRoleRelations.forEach(
                    (relation) -> roleRepository.findById(relation.getRoleId()).ifPresent(
                            (role -> roleNames.add(role.getRole()))
                    )
            );
        }

        return roleNames;
    }

    @Override
    public UserInfoVo createUser(UserCreateVo createVo) {
        if (createVo == null) {
            throw new ServiceException(ErrorCode.CREATE_WITH_NO_INFO);
        }

        User user = new User();
        BeanUtils.copyProperties(createVo, user);
        user.setRegisterDate(new Date());

        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        String password = createVo.getPassword();
        Object credentials = new SimpleHash(  ShiroConstant.HASH_ALGORITHM_NAME,
                                    password,
                                    salt,
                                    ShiroConstant.HASH_ITERATIONS);
        user.setSalt(salt);
        user.setPassword(credentials.toString());


        user = userRepository.save(user);

        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);

        return userInfoVo;
    }
}

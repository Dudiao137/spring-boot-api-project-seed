package win.ots.hello.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.ots.hello.dao.RoleRepository;
import win.ots.hello.dao.UserRepository;
import win.ots.hello.dao.UserRoleRelationRepository;
import win.ots.hello.entity.User;
import win.ots.hello.entity.UserRoleRelation;
import win.ots.hello.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}

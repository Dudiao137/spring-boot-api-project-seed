package win.ots.hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import win.ots.hello.dao.UserRepository;
import win.ots.hello.entity.User;
import win.ots.hello.service.UserService;

import java.util.List;

/**
 * @author: sy.wang
 * @date: 20190926
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}

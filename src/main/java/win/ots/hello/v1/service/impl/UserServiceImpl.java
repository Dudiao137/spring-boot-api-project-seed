package win.ots.hello.v1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import win.ots.hello.constant.ErrorMessage;
import win.ots.hello.constant.RoleEnum;
import win.ots.hello.constant.SexEnum;
import win.ots.hello.constant.ShiroConstant;
import win.ots.hello.core.exception.ServiceException;
import win.ots.hello.v1.entity.Role;
import win.ots.hello.v1.entity.User;
import win.ots.hello.v1.entity.UserRoleRelation;
import win.ots.hello.v1.mapper.RoleMapper;
import win.ots.hello.v1.mapper.UserMapper;
import win.ots.hello.v1.mapper.UserRoleRelationMapper;
import win.ots.hello.v1.service.IUserRoleRelationService;
import win.ots.hello.v1.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import win.ots.hello.web.vo.UserCreateVo;
import win.ots.hello.web.vo.UserInfoVo;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleRelationMapper userRoleRelationMapper;

    @Autowired
    private IUserRoleRelationService userRoleRelationService;


    @Override
    public User getByUserName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);

        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public Set<String> getRolesByUserId(Long userId) {
        QueryWrapper<UserRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<UserRoleRelation> roleRelations = userRoleRelationMapper.selectList(queryWrapper);
        Set<String> roles = new HashSet<>();
        if (CollectionUtils.isNotEmpty(roleRelations)) {
            roleRelations.forEach(relation -> {
                Optional.ofNullable(roleMapper.selectById(relation.getRoleId()))
                        .ifPresent(role -> roles.add(role.getRole()));
            });
        }

        return roles;
    }

    @Override
    public List<User> getPageByQuery() {
        return null;
    }

    @Override
    public UserInfoVo register(UserCreateVo createVo) {

        User user = this.getByUserName(createVo.getUserName());
        if (user != null) {
            throw new ServiceException(ErrorMessage.USER_NAME_EXIST.getMessage());
        }
        user = new User();
        BeanUtils.copyProperties(createVo, user);
        user.setRegisterDate(new Date());
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String password = user.getPassword();
        password = new Md5Hash(password, salt, ShiroConstant.HASH_ITERATIONS).toString();
        user.setPassword(password);
        user.setSalt(salt);
        userMapper.insert(user);

        return this.getUserInfo(user);
    }

    @Override
    public UserInfoVo getUserInfo(Long userId) {

        User user = userMapper.selectById(userId);
        return this.getUserInfo(user);
    }

    public UserInfoVo getUserInfo(User user) {
        UserInfoVo userInfoVo = new UserInfoVo();
        if (user != null) {
            BeanUtils.copyProperties(user, userInfoVo);
            userInfoVo.setSexName(SexEnum.getById(user.getSex()).toString());
            Set<String> roles = this.getRolesByUserId(user.getId());
            userInfoVo.getRoles().addAll(roles);
        }
        return userInfoVo;
    }

}

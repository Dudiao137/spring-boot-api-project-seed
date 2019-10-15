package win.ots.hello.web.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.ots.hello.constant.ErrorMessage;
import win.ots.hello.constant.RoleEnum;
import win.ots.hello.constant.SexEnum;
import win.ots.hello.core.exception.ServiceException;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;

import win.ots.hello.entity.User;
import win.ots.hello.entity.UserRoleRelation;
import win.ots.hello.service.UserRoleRelationService;
import win.ots.hello.service.UserService;
import win.ots.hello.web.query.UserQuery;
import win.ots.hello.web.vo.UserCreateVo;
import win.ots.hello.web.vo.UserInfoVo;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: sy.wang
 * @date: 20190926
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public Result<User> get(@PathVariable(value = "user_id") int userId) {

        User user = userService.get(userId);
        return ResultGenerator.genSuccessResult(user);
    }

    @RequiresRoles("admin")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<User>> list(@RequestBody UserQuery query) {
        List<User> users = userService.findAllList();
        return ResultGenerator.genSuccessResult(users);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<UserInfoVo> doRegister(@RequestBody @Valid UserCreateVo createVo) {
        User user = userService.getByUserName(createVo.getUserName());
        if (user != null) {
            throw new ServiceException(ErrorMessage.USER_NAME_EXIST.getMessage());
        }
        user = new User();
        BeanUtils.copyProperties(createVo, user);

        userService.insert(user);

        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);
        userInfoVo.setSexName(SexEnum.getById(user.getSex()).toString());

        UserRoleRelation userRoleRelation = new UserRoleRelation();
        userRoleRelation.setUserId(user.getId());
        userRoleRelation.setRoleId(RoleEnum.user.getId());
        userRoleRelationService.insert(userRoleRelation);
        userInfoVo.getRoles().add(RoleEnum.user.getRoleName());


        return ResultGenerator.genSuccessResult(userInfoVo);
    }


}

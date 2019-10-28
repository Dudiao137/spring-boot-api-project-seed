package win.ots.hello.web.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.ots.hello.constant.ShiroConstant;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.v1.entity.User;
import win.ots.hello.v1.service.IUserRoleRelationService;
import win.ots.hello.v1.service.IUserService;
import win.ots.hello.web.query.UserQuery;
import win.ots.hello.web.vo.UserCreateVo;
import win.ots.hello.web.vo.UserInfoVo;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: sy.wang
 * @date: 20190926
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleRelationService userRoleRelationService;

    @RequiresRoles({ShiroConstant.ROLE_ADMIN})
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public Result<User> get(@PathVariable(value = "user_id") Long userId) {

        User user = userService.getById(userId);
        return ResultGenerator.genSuccessResult(user);
    }

    @RequiresRoles({ShiroConstant.ROLE_ADMIN})
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<User>> list(@RequestBody UserQuery query) {
        List<User> users = userService.getPageByQuery();
        return ResultGenerator.genSuccessResult(users);
    }

    @RequestMapping(value = "/info/{user_id}", method = RequestMethod.GET)
    public Result<UserInfoVo> getUserInfo(@PathVariable(value = "user_id") Long userId) {

        UserInfoVo userInfo = userService.getUserInfo(userId);
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<UserInfoVo> doRegister(@RequestBody @Valid UserCreateVo createVo) {

        UserInfoVo userInfoVo = userService.register(createVo);
        return ResultGenerator.genSuccessResult(userInfoVo);
    }


}

package win.ots.hello.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api("用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleRelationService userRoleRelationService;

    @ApiOperation("查询用户信息")
    @RequiresRoles({ShiroConstant.ROLE_ADMIN})
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public Result<User> get(@ApiParam("用户id") @PathVariable(value = "user_id") Long userId) {

        User user = userService.getById(userId);
        return ResultGenerator.genSuccessResult(user);
    }

    @ApiOperation("获取用户列表")
    @RequiresRoles({ShiroConstant.ROLE_ADMIN})
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<User>> list(@RequestBody UserQuery query) {
        List<User> users = userService.getPageByQuery();
        return ResultGenerator.genSuccessResult(users);
    }

    @ApiOperation("获取用户详细信息")
    @RequestMapping(value = "/info/{user_id}", method = RequestMethod.GET)
    public Result<UserInfoVo> getUserInfo(@ApiParam("用户id") @PathVariable(value = "user_id") Long userId) {

        UserInfoVo userInfo = userService.getUserInfo(userId);
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<UserInfoVo> doRegister(@RequestBody @Valid UserCreateVo createVo) {

        UserInfoVo userInfoVo = userService.register(createVo);
        return ResultGenerator.genSuccessResult(userInfoVo);
    }


}

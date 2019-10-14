package win.ots.hello.web.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;

import win.ots.hello.entity.User;
import win.ots.hello.service.UserService;
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
    private UserService userService;

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
        User user = new User();
        BeanUtils.copyProperties(createVo, user);

        userService.insert(user);

        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);

        return ResultGenerator.genSuccessResult(userInfoVo);
    }


}

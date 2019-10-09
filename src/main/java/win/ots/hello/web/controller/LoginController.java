package win.ots.hello.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.entity.User;
import win.ots.hello.service.UserService;
import win.ots.hello.web.vo.UserCreateVo;
import win.ots.hello.web.vo.UserInfoVo;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result doLogin(@RequestParam(value = "user_name") String userName,
                          @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(userName, password));
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result doLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<UserInfoVo> doRegister(@RequestBody UserCreateVo createVo) {
        User user = new User();
        BeanUtils.copyProperties(createVo, user);

        userService.insert(user);

        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(user, userInfoVo);

        return ResultGenerator.genSuccessResult(userInfoVo);
    }


    @RequestMapping(value = "/login_page", method = RequestMethod.GET)
    public String login() {
        return "please login!";
    }

}

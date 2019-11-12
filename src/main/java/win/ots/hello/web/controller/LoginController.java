package win.ots.hello.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import win.ots.hello.constant.ShiroConstant;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.v1.entity.User;
import win.ots.hello.v1.service.IUserService;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Api("登录管理")
@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户登录", httpMethod = "Get")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result doLogin(@ApiParam("用户名") @RequestParam(value = "user_name") String userName,
                          @ApiParam("登录密码") @RequestParam(value = "password") String password) {
        User user = userService.getByUserName(userName);
        if (user == null) {
            throw new AuthenticationException("no user with userName :" + userName);
        }
        Subject subject = SecurityUtils.getSubject();
        password = new Md5Hash(password, user.getSalt(), ShiroConstant.HASH_ITERATIONS).toString();
        subject.login(new UsernamePasswordToken(userName, password));
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "用户退出", httpMethod = "Post")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result doLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/login_page", method = RequestMethod.GET)
    public String login() {
        return "please login!";
    }

}

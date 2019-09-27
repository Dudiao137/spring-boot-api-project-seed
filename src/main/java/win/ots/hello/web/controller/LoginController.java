package win.ots.hello.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public void doLogin(@RequestParam(value = "user_name") String userName,
                        @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(userName, password));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "please login!";
    }

}

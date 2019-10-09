package win.ots.hello.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.entity.User;
import win.ots.hello.service.UserService;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public Result<List<User>> list() {
        List<User> users = userService.findAllList();
        return ResultGenerator.genSuccessResult(users);
    }

    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Result<User> get(@RequestParam String id) {
        User user = userService.get(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody User user) {
        if (userService.insert(user) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public String insertBatch(@RequestBody List<User> users) {
        if (userService.insertBatch(users) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody User user) {
        if (userService.update(user) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody User user) {
        if (userService.delete(user) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

}

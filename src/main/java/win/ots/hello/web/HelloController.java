package win.ots.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;


/**
 * @author: sy.wang
 * @date: 20190926
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public Result<String> index() {
        return ResultGenerator.genSuccessResult();
    }
}

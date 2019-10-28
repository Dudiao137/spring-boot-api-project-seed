package win.ots.hello.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.web.vo.TestVo;

import javax.validation.Valid;


/**
 * @author: sy.wang
 * @date: 20190926
 */
@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/")
    public Result<String> index() {
        return ResultGenerator.genSuccessResult();
    }
}

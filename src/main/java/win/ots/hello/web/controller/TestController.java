package win.ots.hello.web.controller;

import io.swagger.annotations.Api;
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
 * @author : sy.wang
 * @date : 2019-10-28
 */
@Api("测试")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/valid", method = RequestMethod.POST)
    public Result<Object> test(@RequestBody @Valid TestVo testVo) {
        log.info("input:" + testVo);
        return ResultGenerator.genSuccessResult(testVo);
    }

}

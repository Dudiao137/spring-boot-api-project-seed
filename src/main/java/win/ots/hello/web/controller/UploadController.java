package win.ots.hello.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import win.ots.hello.constant.ErrorMessage;
import win.ots.hello.core.exception.ServiceException;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.v1.service.IFileUploadService;
import win.ots.hello.web.vo.UploadResultVo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : sy.wang
 * @date : 2019-10-17
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private IFileUploadService fileUploadService;

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public Result<UploadResultVo> simpleUpload(@RequestParam("file") MultipartFile multipartFile){

        UploadResultVo resultVo = fileUploadService.simpleUpload(multipartFile);

        return ResultGenerator.genSuccessResult(resultVo);
    }

    @RequestMapping(value = "/multi", method = RequestMethod.POST)
    public Result<List<UploadResultVo>> multiUpload(@RequestParam("files") List<MultipartFile> multipartFiles){
        if (CollectionUtils.isEmpty(multipartFiles)) {
            return ResultGenerator.genFailResult(ErrorMessage.NO_FILE_TO_UPLOAD.getMessage());
        }

        List<UploadResultVo> uploadResultVos = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            UploadResultVo resultVo = fileUploadService.simpleUpload(multipartFile);
            uploadResultVos.add(resultVo);
        }

        return ResultGenerator.genSuccessResult(uploadResultVos);
    }
}

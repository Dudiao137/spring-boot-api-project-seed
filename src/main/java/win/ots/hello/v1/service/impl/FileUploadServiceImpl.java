package win.ots.hello.v1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import win.ots.hello.constant.ErrorMessage;
import win.ots.hello.core.exception.ServiceException;
import win.ots.hello.v1.service.IFileUploadService;
import win.ots.hello.web.vo.UploadResultVo;

import java.io.File;
import java.io.IOException;

/**
 * @author : sy.wang
 * @date : 2019-10-17
 */
@Slf4j
@Service
public class FileUploadServiceImpl implements IFileUploadService {

    @Value("${common.base-upload-file}")
    private String BASE_UPLOAD_PATH;


    @Override
    public UploadResultVo simpleUpload(MultipartFile multipartFile) {

        if (multipartFile.isEmpty()) {
            throw new ServiceException(ErrorMessage.NO_FILE_TO_UPLOAD.getMessage());
        }

        String fileName = multipartFile.getOriginalFilename();
        String filePath = BASE_UPLOAD_PATH + "data" + "/";
        File dest = new File(filePath + fileName);
        UploadResultVo resultVo = new UploadResultVo();
        try {
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            multipartFile.transferTo(dest);
            // todo: add file to cdn
            resultVo.setFileName(fileName);
            resultVo.setFileUrl(dest.getAbsolutePath());
        } catch (IOException e) {
            log.error("upload file error", e);
        }

        return resultVo;
    }
}

package win.ots.hello.v1.service;

import org.springframework.web.multipart.MultipartFile;
import win.ots.hello.web.vo.UploadResultVo;

/**
 * @author : sy.wang
 * @date : 2019-10-17
 */
public interface IFileUploadService {

    UploadResultVo simpleUpload(MultipartFile multipartFile);

}

package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.Image;
import win.ots.hello.v1.mapper.ImageMapper;
import win.ots.hello.v1.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

}

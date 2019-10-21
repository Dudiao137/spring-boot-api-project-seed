package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.Brand;
import win.ots.hello.v1.mapper.BrandMapper;
import win.ots.hello.v1.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品品牌表 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}

package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.Sku;
import win.ots.hello.v1.mapper.SkuMapper;
import win.ots.hello.v1.service.ISkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Stock Keeping Unit: 库存量单位 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {

}

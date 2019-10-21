package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.SkuSpecValue;
import win.ots.hello.v1.mapper.SkuSpecValueMapper;
import win.ots.hello.v1.service.ISkuSpecValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku 与 规格值 的关联表 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class SkuSpecValueServiceImpl extends ServiceImpl<SkuSpecValueMapper, SkuSpecValue> implements ISkuSpecValueService {

}

package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.SpuSpec;
import win.ots.hello.v1.mapper.SpuSpecMapper;
import win.ots.hello.v1.service.ISpuSpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * spu与规格关联表 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class SpuSpecServiceImpl extends ServiceImpl<SpuSpecMapper, SpuSpec> implements ISpuSpecService {

}

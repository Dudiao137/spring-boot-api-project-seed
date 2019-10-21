package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.SpecValue;
import win.ots.hello.v1.mapper.SpecValueMapper;
import win.ots.hello.v1.service.ISpecValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 规格值表 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class SpecValueServiceImpl extends ServiceImpl<SpecValueMapper, SpecValue> implements ISpecValueService {

}

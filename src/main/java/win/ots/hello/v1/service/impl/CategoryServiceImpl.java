package win.ots.hello.v1.service.impl;

import win.ots.hello.v1.entity.Category;
import win.ots.hello.v1.mapper.CategoryMapper;
import win.ots.hello.v1.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类别表 服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-17
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}

package win.ots.hello.v1.service;

import win.ots.hello.v1.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import win.ots.hello.web.vo.RoleUserVo;
import win.ots.hello.web.vo.RoleVo;
import win.ots.hello.web.vo.UserRoleRelationInputVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-16
 */
public interface IRoleService extends IService<Role> {

    List<RoleUserVo> batchRegister(List<UserRoleRelationInputVo> inputVos);

    RoleVo add(RoleVo inputVo);
}

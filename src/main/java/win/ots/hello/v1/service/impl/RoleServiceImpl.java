package win.ots.hello.v1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import win.ots.hello.constant.ErrorMessage;
import win.ots.hello.constant.RoleEnum;
import win.ots.hello.core.exception.ServiceException;
import win.ots.hello.v1.entity.Role;
import win.ots.hello.v1.entity.UserRoleRelation;
import win.ots.hello.v1.mapper.RoleMapper;
import win.ots.hello.v1.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import win.ots.hello.v1.service.IUserRoleRelationService;
import win.ots.hello.web.vo.RoleUserVo;
import win.ots.hello.web.vo.RoleVo;
import win.ots.hello.web.vo.UserRoleRelationInputVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private IUserRoleRelationService userRoleRelationService;

    @Override
    public RoleVo add(RoleVo inputVo) {
        String roleMark = inputVo.getRole();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role", roleMark);
        Integer count = roleMapper.selectCount(queryWrapper);
        if (count == null || count == 0) {
            Role role = new Role();
            BeanUtils.copyProperties(inputVo, role);
            roleMapper.insert(role);
        } else {
            throw new ServiceException(ErrorMessage.ROLE_EXIST.getMessage());
        }

        return inputVo;
    }

    @Override
    public List<RoleUserVo> batchRegister(List<UserRoleRelationInputVo> inputVos) {

        List<UserRoleRelation> roleRelations = new ArrayList<>();
        inputVos.forEach(inputVo -> {
            UserRoleRelation roleRelation = new UserRoleRelation();
            BeanUtils.copyProperties(inputVo, roleRelation);
            roleRelations.add(roleRelation);
        });
        userRoleRelationService.saveBatch(roleRelations);

        List<RoleUserVo> roleVos = new ArrayList<>();
        roleRelations.forEach(roleRelation -> {
            RoleUserVo roleVo = new RoleUserVo();
            roleVo.setUserId(roleRelation.getUserId());
            roleVo.setRoleId(roleRelation.getRoleId());
            RoleEnum roleEnum = RoleEnum.getById(roleRelation.getRoleId());
            roleVo.setRole(roleEnum.name());
            roleVo.setRoleName(roleEnum.getRoleName());
            roleVos.add(roleVo);
        });

        return roleVos;
    }
}

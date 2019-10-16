package win.ots.hello.web.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import win.ots.hello.constant.ShiroConstant;
import win.ots.hello.core.result.Result;
import win.ots.hello.core.result.ResultGenerator;
import win.ots.hello.v1.service.IRoleService;
import win.ots.hello.v1.service.IUserRoleRelationService;
import win.ots.hello.web.vo.RoleVo;
import win.ots.hello.web.vo.RoleUserVo;
import win.ots.hello.web.vo.UserRoleRelationInputVo;

import javax.validation.Valid;
import java.util.List;

/**
 * @author : sy.wang
 * @date : 20191016
 */
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleRelationService userRoleRelationService;

    @RequiresRoles({ShiroConstant.ROLE_ROOT})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<RoleVo> addRoleRelation(@RequestBody @Valid RoleVo inputVo) {
        RoleVo roleVo = roleService.add(inputVo);
        return ResultGenerator.genSuccessResult(roleVo);
    }

    @RequiresRoles({ShiroConstant.ROLE_ROOT})
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<List<RoleUserVo>> addRoleRelation(@RequestBody @Valid List<UserRoleRelationInputVo> inputVos) {
        List<RoleUserVo> roleVos = roleService.batchRegister(inputVos);
        return ResultGenerator.genSuccessResult(roleVos);
    }


}

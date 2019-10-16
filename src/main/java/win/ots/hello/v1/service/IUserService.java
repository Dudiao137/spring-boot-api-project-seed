package win.ots.hello.v1.service;

import win.ots.hello.v1.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import win.ots.hello.web.vo.UserCreateVo;
import win.ots.hello.web.vo.UserInfoVo;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-15
 */
public interface IUserService extends IService<User> {

    User getByUserName(String userName);

    Set<String> getRolesByUserId(Integer id);

    List<User> getPageByQuery();

    UserInfoVo register(UserCreateVo createVo);

    UserInfoVo getUserInfo(Integer userId);
}

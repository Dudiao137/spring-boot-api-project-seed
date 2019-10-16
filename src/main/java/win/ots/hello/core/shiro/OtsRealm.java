package win.ots.hello.core.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import win.ots.hello.v1.entity.User;
import win.ots.hello.v1.service.IUserService;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Component
public class OtsRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        User user = userService.getByUserName(userName);

        Set<String> roles = userService.getRolesByUserId(user.getId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.setRoles(roles);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        User user = userService.getByUserName(userName);

        if (user == null) {
            throw new AuthenticationException("no user with userName :" + userName);
        }

        ByteSource salt = ByteSource.Util.bytes(user.getSalt());

        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(
                        user.getUserName(),
                        user.getPassword(),
                        salt,
                        getName());

        return authenticationInfo;
    }
}

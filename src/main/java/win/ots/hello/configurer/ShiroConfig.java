package win.ots.hello.configurer;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import win.ots.hello.core.shiro.OtsRealm;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : sy.wang
 * @date : 20190927
 */
@Configuration
public class ShiroConfig {

    @Resource
    private OtsRealm otsRealm;

    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(otsRealm);
        return manager;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/login_page");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauthorizedUrl");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("/login", "anon");
        map.put("/users/register", "anon");
        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);

        return bean;
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();

        /**
         * 在引入spring apo 下，在controller中加入requiresRole会导致404的奇怪bug
         */
        creator.setUsePrefix(true);

        return creator;
    }

}

package com.company.project.v1.service.impl;

import com.company.project.v1.entity.User;
import com.company.project.v1.mapper.UserMapper;
import com.company.project.v1.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

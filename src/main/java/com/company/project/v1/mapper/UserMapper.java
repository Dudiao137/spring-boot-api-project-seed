package com.company.project.v1.mapper;

import com.company.project.v1.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sy.wang
 * @since 2019-10-15
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from tbl_user where user_name = #{name}")
    User findByName(String name);

    @Deprecated
    User findByName2(@Param("user_name") String userName);
}

package win.ots.hello.service;

import win.ots.hello.entity.UserRoleRelation;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
public interface UserRoleRelationService {

    UserRoleRelation get(int id);

    List<UserRoleRelation> findList(UserRoleRelation userRoleRelation);

    List<UserRoleRelation> findAllList();

    int insert(UserRoleRelation userRoleRelation);

    int insertBatch(List<UserRoleRelation> userRoleRelations);

    int update(UserRoleRelation userRoleRelation);

    int delete(UserRoleRelation userRoleRelation);

}

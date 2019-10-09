package win.ots.hello.dao;

import win.ots.hello.entity.UserRoleRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Repository
public interface UserRoleRelationDao {

    UserRoleRelation get(int id);

    List<UserRoleRelation> findList(UserRoleRelation userRoleRelation);

    List<UserRoleRelation> findAllList();

    int insert(UserRoleRelation userRoleRelation);

    int insertBatch(List<UserRoleRelation> userRoleRelations);

    int update(UserRoleRelation userRoleRelation);

    int delete(UserRoleRelation userRoleRelation);

}
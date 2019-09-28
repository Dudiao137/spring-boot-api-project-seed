package win.ots.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import win.ots.hello.entity.User;
import win.ots.hello.entity.UserRoleRelation;

import java.util.List;

/**
 * @author : sy.wang
 * @date : 20190925
 */
@Repository
public interface UserRoleRelationRepository extends JpaRepository<UserRoleRelation, Long> {

    @Query
    List<UserRoleRelation> getAllByUserId(Long userId);

}

package win.ots.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import win.ots.hello.entity.Role;
import win.ots.hello.entity.User;

/**
 * @author : sy.wang
 * @date : 20190925
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


}

package win.ots.hello.service.impl;

import win.ots.hello.dao.UserRoleRelationDao;
import win.ots.hello.entity.UserRoleRelation;
import win.ots.hello.service.UserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: sy.wang
 * Date: 20191009
 */
@Service
public class UserRoleRelationServiceImpl implements UserRoleRelationService {

    @Autowired
    private UserRoleRelationDao userRoleRelationDao;

    
    @Override
    public UserRoleRelation get(int id){
        return userRoleRelationDao.get(id);
    }
    
    @Override
    public List<UserRoleRelation> findList(UserRoleRelation userRoleRelation) {
        return userRoleRelationDao.findList(userRoleRelation);
    }
    
    @Override
    public List<UserRoleRelation> findAllList() {
        return userRoleRelationDao.findAllList();
    }
    
    @Override
    public int insert(UserRoleRelation userRoleRelation) {
        return userRoleRelationDao.insert(userRoleRelation);
    }
    
    @Override
    public int insertBatch(List<UserRoleRelation> userRoleRelations){
        return userRoleRelationDao.insertBatch(userRoleRelations);
    }
    
    @Override
    public int update(UserRoleRelation userRoleRelation) {
        return userRoleRelationDao.update(userRoleRelation);
    }
    
    @Override
    public int delete(UserRoleRelation userRoleRelation) {
        return userRoleRelationDao.delete(userRoleRelation);
    }

}

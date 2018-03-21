
package com.zcchock.provideruser.dao;

import com.zcchock.provideruser.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, String> {

    UserEntity findUserEntityById(String id);

    UserEntity findUserEntityByIdAndSex(String id, String sex);

}
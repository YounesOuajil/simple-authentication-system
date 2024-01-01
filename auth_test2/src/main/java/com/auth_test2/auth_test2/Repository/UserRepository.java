package com.auth_test2.auth_test2.Repository;

import com.auth_test2.auth_test2.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    UserEntity findByUsername(String username);
}


package com.widetns.lunchProject.lunchProject.repository;

import com.widetns.lunchProject.lunchProject.userDomain.TestUserDomain;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TestUserDomain,String> {

    TestUserDomain findByUserIdAndUserPassword(String userId, String userPassword);

}

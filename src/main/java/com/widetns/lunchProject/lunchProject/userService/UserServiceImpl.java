package com.widetns.lunchProject.lunchProject.userService;

import com.widetns.lunchProject.lunchProject.repository.UserRepository;
import com.widetns.lunchProject.lunchProject.userDomain.TestUserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repo;

    public TestUserDomain checkUser(TestUserDomain user){


        return repo.findByUserIdAndUserPassword(user.getUserId(),user.getUserPassword());
    }


}

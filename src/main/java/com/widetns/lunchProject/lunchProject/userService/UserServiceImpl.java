package com.widetns.lunchProject.lunchProject.userService;

import com.widetns.lunchProject.lunchProject.entity.Member;
import com.widetns.lunchProject.lunchProject.repository1.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    MemberRepository repo;


    public Member checkUser(Member user){


        return repo.findByMemberIdAndPassword(user.getMemberId(),user.getPassword());
    }


}

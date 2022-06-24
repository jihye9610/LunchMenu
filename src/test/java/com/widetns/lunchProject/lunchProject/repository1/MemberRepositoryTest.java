package com.widetns.lunchProject.lunchProject.repository1;

import com.widetns.lunchProject.lunchProject.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private  MemberRepository memberRepository;

    @Test
    public void join() {
        Member member = new Member();
        member.setUserName("test");
        member.setId("test");
        member.setPassword("test");

        memberRepository.save(member);

    }
   }
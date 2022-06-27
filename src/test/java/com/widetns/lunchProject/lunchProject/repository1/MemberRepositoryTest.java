package com.widetns.lunchProject.lunchProject.repository1;

import com.widetns.lunchProject.lunchProject.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class MemberRepositoryTest {

    @Autowired
    private JpaStoreRepository jpaStoreRepository;

    @Test
    public void join() {
        Member member = new Member();
        member.setUserName("wndgks49");
        member.setMemberId("tysianb");
        member.setPassword("132412");

        jpaStoreRepository.save(member);

    }
   }
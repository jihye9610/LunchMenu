package com.widetns.lunchProject.lunchProject.service;

import com.widetns.lunchProject.lunchProject.entity.Member;
import com.widetns.lunchProject.lunchProject.repository1.JpaStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    @Autowired
    private final JpaStoreRepository jpaStoreRepository;


    public Integer join(Member member){
//        validateDuplicateMember(member);
        jpaStoreRepository.save(member);
        return member.getUserIdx();
    }

    public boolean existsByMemberId(String MemberId){
        return jpaStoreRepository.existsBymemberId(MemberId);
    }

    public List<Member> findAll(){
        return jpaStoreRepository.findAll();
    }


}

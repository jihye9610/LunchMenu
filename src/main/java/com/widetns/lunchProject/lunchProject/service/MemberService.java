package com.widetns.lunchProject.lunchProject.service;

import com.widetns.lunchProject.lunchProject.entity.Member;
import com.widetns.lunchProject.lunchProject.repository1.MemberRepository;
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
    private final MemberRepository memberRepository;


    public Integer join(Member member){
//        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getUserIdx();
    }

    public boolean existsByMemberId(String MemberId){
        return memberRepository.existsBymemberId(MemberId);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }


}

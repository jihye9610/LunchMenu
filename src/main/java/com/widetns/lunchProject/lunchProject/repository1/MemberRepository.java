package com.widetns.lunchProject.lunchProject.repository1;

import com.widetns.lunchProject.lunchProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByIdAndPassword(String userId, String userPassword);

    boolean existsBymemberId(String MemberId);

    Member findById(String id);
}

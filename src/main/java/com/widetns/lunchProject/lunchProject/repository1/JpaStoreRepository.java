package com.widetns.lunchProject.lunchProject.repository1;

import com.widetns.lunchProject.lunchProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JpaStoreRepository extends JpaRepository<Member, Integer> {

    boolean existsBymemberId(String MemberId);
}

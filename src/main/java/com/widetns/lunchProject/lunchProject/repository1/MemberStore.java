//package com.widetns.lunchProject.lunchProject.repository1;
//
//
//import com.widetns.lunchProject.lunchProject.entity.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//
//@RequiredArgsConstructor
//public class MemberStore implements MemberRepository{
//
//    @Autowired
//    private final EntityManager em;
//
//
//    private MemberRepository memberRepository;
//
//    @Override
//    public Member save(Member member) {
//        em.persist(member);
//        return  member;
//    }
//
//    @Override
//    public Optional<Member> findbyId(String memberId) {
//        Member findId = em.createQuery("Select m from Member m where id =: id", Member.class)
//                .setParameter("id", memberId)
//                .getSingleResult();
//        return Optional.ofNullable(findId);
//    }
//
//    @Override
//    public Optional<Member> findbyName(String name) {
//        List<Member> findName = em.createQuery("Select m from Member m where userName =: userName", Member.class)
//               .setParameter("userName", name)
//               .getResultList();
//        return findName.stream().findAny();
//    }
//
//    @Override
//    public Optional<Member> findbyEmail(String email) {
//        Member findEmail = em.createQuery("Select m from Member where email =: email", Member.class)
//                .setParameter("email", email)
//                .getSingleResult();
//        return Optional.ofNullable(findEmail);
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return em.createQuery("Select m from Member m ", Member.class).getResultList();
//    }
//
//
//    // 엔티티 쿼리문은 entity 테이블 네임을 따라가는것이 아닌 객체이름 으로 적어줘야함.
//}

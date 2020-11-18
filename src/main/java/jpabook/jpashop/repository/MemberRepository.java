package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // 스프링이 처리해줌
    // 엔티티매니저를 생성해서 주입해준다
    //@PersistenceContext
    //Spring Data JPA에서는 @Autowired로도 가능
    private final EntityManager em;

    // 엔티티매니저팩토리 직접 주입받는 것도 가능
//    @PersistenceUnit
//    private EntityManagerFactory emf;

    // 저장 로직
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 조회 로직
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 조회 로직
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 이름으로 조회하는 로직
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}

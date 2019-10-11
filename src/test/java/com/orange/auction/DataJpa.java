package com.orange.auction;


import com.orange.auction.dao.MemberDao;
import com.orange.auction.dao.MemberDaoImpl;
import com.orange.auction.dao.MemberRepository;
import com.orange.auction.model.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpa {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void name() {
        testEntityManager.persist(new Member("Suraj", "a@a.com"));
        Member member = memberRepository.findByEmail("a@a.com");
        Assertions.assertThat(member.getFirstName()).isEqualTo("Suraj");
    }
}

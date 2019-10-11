package com.orange.auction.dao;

import com.orange.auction.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByEmail(String email);
}

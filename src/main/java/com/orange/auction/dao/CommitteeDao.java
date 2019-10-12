package com.orange.auction.dao;

import com.orange.auction.model.Committee;

import java.util.List;
import java.util.Optional;

public interface CommitteeDao {
    Optional<Committee> getCommittee(Long id);
    void addNewCommittee(Committee committee);
    List<Committee> getAll();
    void updateCommittee(Committee committee);
}

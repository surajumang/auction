package com.orange.auction.dao;

import com.orange.auction.model.Committee;

import java.util.List;

public interface CommitteeDao {
    Committee getById(Long id);
    void add(Committee committee);
    List<Committee> getAll();
}

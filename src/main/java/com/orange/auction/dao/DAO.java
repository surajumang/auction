package com.orange.auction.dao;

public interface DAO<T> {

    default T getById(){
        return null;
    }
}

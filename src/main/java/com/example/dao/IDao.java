package com.example.dao;

import java.security.NoSuchAlgorithmException;

public interface IDao<T>{

    T getBasedOnLogin(String email);
    boolean create(T o) throws NoSuchAlgorithmException;
    boolean update(T o);
}

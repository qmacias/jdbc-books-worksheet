package com.cqube.idao;

import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericDAO<T> {
    public List<T> findAll() throws DAOException;
}

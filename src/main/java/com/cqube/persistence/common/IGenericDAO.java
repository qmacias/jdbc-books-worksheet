package com.cqube.persistence.common;

import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericDAO<T> {
	public int insert(T t) throws DAOException;
	public int update(T t) throws DAOException;
	public int delete(T t) throws DAOException;
	public T find(Long id) throws DAOException;
	public List<T> findAll() throws DAOException;
}

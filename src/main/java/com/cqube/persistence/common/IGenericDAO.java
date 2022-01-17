package com.cqube.persistence.common;

import java.sql.SQLException;
import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericDAO<T, K> {
	public int insert(T t) throws DAOException, SQLException;
	public int update(T t) throws DAOException, SQLException;
	public int delete(T t) throws DAOException, SQLException;
	public T find(K id) throws DAOException;
	public List<T> findAll() throws DAOException;
}

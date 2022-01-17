package com.cqube.service.common;

import java.sql.SQLException;
import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericService<T, K> {
	public int delete(K id) throws DAOException, SQLException;
	public T find(K id) throws DAOException;
	public List<T> listAll() throws DAOException;
}

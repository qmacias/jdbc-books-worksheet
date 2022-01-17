package com.cqube.controller.common;

import java.sql.SQLException;
import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericController<T, K> {
	public T remove(K id) throws DAOException, SQLException;
	public T select(K id) throws DAOException;
	public List<T> selectAll() throws DAOException;
}

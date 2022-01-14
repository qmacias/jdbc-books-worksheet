package com.cqube.controller.common;

import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericController<T> {
	public T remove(Long id) throws DAOException;
	public T select(Long id) throws DAOException;
	public List<T> selectAll() throws DAOException;
}

package com.cqube.service.common;

import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericService<T> {
	public int delete(Long id) throws DAOException;
	public T find(Long id) throws DAOException;
	public List<T> listAll() throws DAOException;
}

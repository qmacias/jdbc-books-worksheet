package com.cqube.iserv;

import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericService<T> {
	public List<T> list() throws DAOException;
}

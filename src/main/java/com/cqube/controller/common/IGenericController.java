package com.cqube.controller.common;

import java.util.List;

import com.cqube.utils.DAOException;

public interface IGenericController<T> {
	public List<T> selectAll() throws DAOException;
}

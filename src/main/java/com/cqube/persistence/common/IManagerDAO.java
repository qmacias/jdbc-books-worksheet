package com.cqube.persistence.common;

import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;

public interface IManagerDAO {
    public IAuthorRepositoryDAO getAuthorDAO();
    public IBookRepositoryDAO getBookDAO();
}

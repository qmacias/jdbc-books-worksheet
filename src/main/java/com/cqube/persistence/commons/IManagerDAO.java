package com.cqube.persistence.commons;

import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;

public interface IManagerDAO {
    public IAuthorRepositoryDAO getAuthorDAO();
    public IBookRepositoryDAO getBookDAO();
}

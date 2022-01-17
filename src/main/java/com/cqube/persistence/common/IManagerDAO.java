package com.cqube.persistence.common;

import com.cqube.persistence.IAuthorRepositoryDAO;
import com.cqube.persistence.IBookRepositoryDAO;
import com.cqube.persistence.IRelatioshipRepositoryDAO;

public interface IManagerDAO {
    public IAuthorRepositoryDAO getAuthorDAO();
    public IBookRepositoryDAO getBookDAO();
    public IRelatioshipRepositoryDAO getRelationshipDAO();
}

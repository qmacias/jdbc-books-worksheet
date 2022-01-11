package com.cqube.idao;

public interface IManagerDAO {
    public IAuthorRepositoryDAO getAuthorDAO();
    public IBookRepositoryDAO getBookDAO();
}

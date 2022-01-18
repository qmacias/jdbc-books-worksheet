package com.cqube.service.proxy;

import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.IRelationshipRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;
import com.cqube.utils.ProxyFactory;

public class ManagerProxyImpl implements IManagerProxy {

	private IManagerService manager;
	private IAuthorRepositoryService authorProxy = null;
	private IBookRepositoryService bookProxy = null;
	private IRelationshipRepositoryService relationshipProxy = null;
	
	public ManagerProxyImpl(IManagerService manager) {
		this.manager = manager;
	}

	@Override
	public IAuthorRepositoryService getAuthorProxy() throws DAOException {
		if (authorProxy == null) {
			authorProxy = ProxyFactory.getAuthorProxyImpl(manager);
		}
		return authorProxy;
	}

	@Override
	public IBookRepositoryService getBookProxy() throws DAOException {
		if (bookProxy == null) {
			bookProxy = ProxyFactory.getBookProxyImpl(manager);
		}
		return bookProxy;
	}

	@Override
	public IRelationshipRepositoryService getRelationshipProxy() throws DAOException {
		if (relationshipProxy  == null) {
			relationshipProxy = ProxyFactory.getRelationshipProxyImpl(manager);
		}
		return relationshipProxy;
	}

}

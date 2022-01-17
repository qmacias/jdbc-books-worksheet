package com.cqube.service.proxy;

import com.cqube.factory.IProxyFactory;
import com.cqube.factory.impl.ProxyFactoryImpl;
import com.cqube.service.IAuthorRepositoryService;
import com.cqube.service.IBookRepositoryService;
import com.cqube.service.common.IManagerService;
import com.cqube.service.proxy.common.IManagerProxy;
import com.cqube.utils.DAOException;

public class ManagerProxyImpl implements IManagerProxy {

	private IManagerService manager;
	private IProxyFactory proxyFactory;
	private IAuthorRepositoryService authorProxy = null;
	private IBookRepositoryService bookProxy = null;
	
	public ManagerProxyImpl(IManagerService manager) {
		this.manager = manager;
		this.proxyFactory = new ProxyFactoryImpl();
	}

	@Override
	public IAuthorRepositoryService getAuthorProxy() throws DAOException {
		if (authorProxy == null) {
			authorProxy = proxyFactory.getAuthorProxyImpl(manager);
		}
		return authorProxy;
	}

	@Override
	public IBookRepositoryService getBookProxy() throws DAOException {
		if (bookProxy == null) {
			bookProxy = proxyFactory.getBookProxyImpl(manager);
		}
		return bookProxy;
	}

}
